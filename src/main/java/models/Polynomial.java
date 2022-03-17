package models;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private ArrayList<Monomial> monomialList = new ArrayList<>();   //lista de monoame

    public Polynomial() {
    }


    public Polynomial addPolynomial(Polynomial polynomial) {
        Polynomial answer = new Polynomial();                  //am creat un nou polinom care va fi raspunsul adunarii
        Polynomial expEgali;
        expEgali = this.isEqualDegrees();
        this.setMonomialList(expEgali.getMonomialList());

        for (Monomial temp : monomialList) {
            for (Monomial temp2 : polynomial.monomialList) {
                if (temp.getDegree() == temp2.getDegree()) {   //daca polinoamele au gradele egale
                    answer.monomialList.add(new Monomial(temp.getCoefficient() + temp2.getCoefficient(), temp.getDegree())); //adunam coeficientii si gradul ramane la fel
                    temp2.goThrough = false;
                    temp.goThrough = false;
                    break;
                } else if (temp.getDegree() < temp2.getDegree() && temp2.goThrough) {    //daca gradul primului polinom este mai mic decat gradul celui de al doilea
                    answer.monomialList.add(new Monomial(temp2.getCoefficient(), temp2.getDegree()));    //luam gradul mai mare
                    temp2.goThrough = false;
                } else if (temp.getDegree() > temp2.getDegree() && temp2.goThrough) {    //invers
                    answer.monomialList.add(new Monomial(temp.getCoefficient(), temp.getDegree()));
                    temp.goThrough = false;
                    break;
                }

            }
        }

        return answer;
    }

    public Polynomial dividePolynomail(Polynomial polynomial) {
        Polynomial answer = new Polynomial();

        return answer;
    }

    public Polynomial substractPolynomial(Polynomial polynomial) {

        Polynomial answer;
        for (Monomial aux : polynomial.monomialList) {
            aux.setCoefficient(-aux.getCoefficient());
        }
        answer = this.addPolynomial(polynomial);

        return answer;
    }

    public Polynomial multiplicatePolynomial(Polynomial polynomial) {
        Polynomial answerTemp = new Polynomial();
        Polynomial answer = new Polynomial();
        for (Monomial temp : this.monomialList)
            for (Monomial temp2 : polynomial.monomialList) {
                answerTemp.monomialList.add(new Monomial(temp.getCoefficient() * temp2.getCoefficient(), temp.getDegree() + temp2.getDegree()));
            }
        answer = answerTemp.isEqualDegrees();

        return answer;
    }

    public Polynomial derivatePolynomial(Polynomial polynomial) {
        Polynomial answer = new Polynomial();
        for (Monomial temp : polynomial.monomialList) {
            answer.monomialList.add(new Monomial(temp.getDegree() * temp.getCoefficient(), temp.getDegree() - 1));
        }
        return answer;
    }

    public Polynomial integratePolynomial(Polynomial polynomial) {   //x pow n+1 / n+1
        Polynomial answer = new Polynomial();
        for (Monomial temp : polynomial.monomialList) {
            answer.monomialList.add(new Monomial(temp.getCoefficient() / (temp.getDegree() + 1), temp.getDegree() + 1));
        }
        return answer;
    }


    public void printPolynomial() {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < monomialList.size(); i++) {
            if (monomialList.get(i).getCoefficient() < 0)
                answer.append(monomialList.get(i).getCoefficient()).append("X").append("^").append(monomialList.get(i).getDegree());
            else {
                if (i == 0) {
                    answer.append(monomialList.get(i).getCoefficient()).append("X").append("^").append(monomialList.get(i).getDegree());

                } else {
                    answer.append("+").append(monomialList.get(i).getCoefficient()).append("X").append("^").append(monomialList.get(i).getDegree());
                }
            }
        }
        System.out.println(answer);


    }

    public Polynomial isEqualDegrees() {
        Polynomial answer = new Polynomial();
        for (Monomial temp : this.monomialList) {
            double tempCoef = 0;
            for (Monomial temp2 : this.monomialList) {
                if (temp.getDegree() == temp2.getDegree() && temp2.goThrough) {
                    tempCoef = tempCoef + temp2.getCoefficient();
                    temp2.goThrough = false;
                }
            }
            if (tempCoef != 0)
                answer.monomialList.add(new Monomial(tempCoef, temp.getDegree()));
        }
        return answer;
    }


    public String polinomToString() {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < monomialList.size(); i++) {
            if (monomialList.get(i).getCoefficient() < 0)
                answer.append(monomialList.get(i).getCoefficient()).append("X").append("^").append(monomialList.get(i).getDegree());
            else {
                if (i == 0) {
                    answer.append(monomialList.get(i).getCoefficient()).append("X").append("^").append(monomialList.get(i).getDegree());

                } else {
                    answer.append("+").append(monomialList.get(i).getCoefficient()).append("X").append("^").append(monomialList.get(i).getDegree());
                }
            }
        }
        return answer.toString();
    }

    public ArrayList<Monomial> getMonomialList() {
        return this.monomialList;
    }

    public void setMonomialList(ArrayList<Monomial> monomialList) {
        this.monomialList = monomialList;
    }


    public Polynomial StringToPolynomial(String polynomString) {

        //https://stackoverflow.com/questions/34946528/decode-polynomial-from-string-with-pattern-and-matcher
        //preluat(cod folosit si in Controller)

        Polynomial answer = new Polynomial();
        String monomialFormat = "([+-]?[\\d\\.]*[a-zA-Z]?\\^?\\d*)", monomialPartsFormat = "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)";

        Pattern p1 = Pattern.compile(monomialFormat);
        Matcher m1 = p1.matcher(polynomString);

        while (!m1.hitEnd()) {
            m1.find();
            Pattern p2 = Pattern.compile(monomialPartsFormat);
            System.out.print(m1.group() + "   ->   ");
            Matcher m2 = p2.matcher(m1.group());

            if (m2.find()) {

                float coefficient;
                try {
                    String coef = m2.group(1);
                    if (isNumeric(coef)) {
                        coefficient = Float.parseFloat(coef);
                    } else {
                        coefficient = Float.parseFloat(coef + "1");
                    }
                } catch (IllegalStateException e) {
                    coefficient = 0.0F;
                }

                int exponent;
                try {
                    String exp = m2.group(3);
                    if (isNumeric(exp)) {
                        exponent = Integer.parseInt(exp);
                    } else {
                        exponent = 1;
                    }
                } catch (IllegalStateException e) {
                    exponent = 0;
                }

                String variable = m2.group(2);

                System.out.println("" + coefficient + variable + "^" + exponent);
                answer.monomialList.add(new Monomial(coefficient, exponent));
            }
        }
        return answer;
    }

    public static boolean isNumeric(String str) {
        return str.matches("[+-]*\\d*\\.?\\d+");
    }


}
