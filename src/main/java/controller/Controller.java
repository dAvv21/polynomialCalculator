package controller;

import models.Polynomial;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private final View view;
    private Polynomial polynomial1;
    public Polynomial polynomial2, polRezultat, polRest;
    private boolean valid1, valid2;

    public Controller(View view, Polynomial polynomial1) {
        this.view = view;
        this.polynomial1 = polynomial1;

        this.polynomial2 = new Polynomial();
        this.polRezultat = new Polynomial();
        this.polRest = new Polynomial();
        this.view.addMultiplicateActionListener(new MultiplicateActionListener());
        this.view.addDivideActionListener(new DivideActionListener());
        this.view.addAdditionActionListener(new AdditionActionListener());
        this.view.addSubstractActionListener(new SubstractActionListener());
        this.view.addIntegrationActionListener(new IntegrationActionListener());
        this.view.addDerivationActionListener(new DerivationActionListener());

    }

    class MultiplicateActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polRezString;
            String pol1 = view.getFirstPolTxt();
            String pol2 = view.getSecondPolTxt();
            polynomial1 = polynomial1.StringToPolynomial(pol1);
            polynomial1.printPolynomial();

            polynomial2 = polynomial2.StringToPolynomial(pol2);
            polynomial2.printPolynomial();
            valid1 = validatePolynomial(pol1);
            valid2 = validatePolynomial(pol2);

            if (valid1 && valid2) {
                polRezultat = polynomial1.multiplicatePolynomial(polynomial2);
                polRezString = polRezultat.polinomToString();
                view.setAnswerTxt(polRezString);
            } else {
                if (!valid1 && !valid2)
                    JOptionPane.showMessageDialog(null, "Invalid input for both polynomials!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (!valid1)
                        JOptionPane.showMessageDialog(null, "Invalid input for the first polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid input for the second polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }

    class DivideActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polRezString;
            String pol1 = view.getFirstPolTxt();
            String pol2 = view.getSecondPolTxt();

            polynomial1 = polynomial1.StringToPolynomial(pol1);
            polynomial1.printPolynomial();

            polynomial2 = polynomial2.StringToPolynomial(pol2);
            polynomial2.printPolynomial();
            valid1 = validatePolynomial(pol1);
            valid2 = validatePolynomial(pol2);

            if (valid1 && valid2) {
                polRezultat = polynomial1.dividePolynomail(polynomial2);
                polRezString = polRezultat.polinomToString();
                view.setAnswerTxt(polRezString);
            } else {
                if (!valid1 && !valid2)
                    JOptionPane.showMessageDialog(null, "Invalid input for both polynomials!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (!valid1)
                        JOptionPane.showMessageDialog(null, "Invalid input for the first polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid input for the second polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }

    class AdditionActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polRezString;
            String pol1 = view.getFirstPolTxt();
            String pol2 = view.getSecondPolTxt();

            polynomial1 = polynomial1.StringToPolynomial(pol1);
            polynomial1.printPolynomial();

            polynomial2 = polynomial2.StringToPolynomial(pol2);
            polynomial2.printPolynomial();
            valid1 = validatePolynomial(pol1);
            valid2 = validatePolynomial(pol2);

            if (valid1 && valid2) {
                polRezultat = polynomial1.addPolynomial(polynomial2);
                polRezString = polRezultat.polinomToString();
                view.setAnswerTxt(polRezString);
            } else {
                if (!valid1 && !valid2)
                    JOptionPane.showMessageDialog(null, "Invalid input for both polynomials!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (!valid1)
                        JOptionPane.showMessageDialog(null, "Invalid input for the first polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid input for the second polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }

    class SubstractActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polRezString;
            String pol1 = view.getFirstPolTxt();
            String pol2 = view.getSecondPolTxt();

            polynomial1 = polynomial1.StringToPolynomial(pol1);
            polynomial1.printPolynomial();

            polynomial2 = polynomial2.StringToPolynomial(pol2);
            polynomial2.printPolynomial();
            valid1 = validatePolynomial(pol1);
            valid2 = validatePolynomial(pol2);

            if (valid1 && valid2) {
                polRezultat = polynomial1.substractPolynomial(polynomial2);
                polRezString = polRezultat.polinomToString();
                view.setAnswerTxt(polRezString);
            } else {
                if (!valid1 && !valid2)
                    JOptionPane.showMessageDialog(null, "Invalid input for both polynomials!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (!valid1)
                        JOptionPane.showMessageDialog(null, "Invalid input for the first polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid input for the second polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }

    class IntegrationActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polRezString;
            String pol1 = view.getFirstPolTxt();
            String pol2 = view.getSecondPolTxt();

            polynomial1 = polynomial1.StringToPolynomial(pol1);
            polynomial1.printPolynomial();

            valid1 = validatePolynomial(pol1);

            if (valid1) {
                polRezultat = polynomial1.integratePolynomial(polynomial1);
                polRezString = polRezultat.polinomToString();
                view.setAnswerTxt(polRezString);
            } else {
                if (!valid1)
                    JOptionPane.showMessageDialog(null, "Invalid input for the polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (pol2 != null)
                        JOptionPane.showMessageDialog(null, "Please introduce the polynomial in first textfield! ", "Error.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }

    class DerivationActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String polRezString;
            String pol1 = view.getFirstPolTxt();
            String pol2 = view.getSecondPolTxt();

            polynomial1 = polynomial1.StringToPolynomial(pol1);
            polynomial1.printPolynomial();

            valid1 = validatePolynomial(pol1);

            if (valid1) {
                polRezultat = polynomial1.derivatePolynomial(polynomial1);
                polRezString = polRezultat.polinomToString();
                view.setAnswerTxt(polRezString);
            } else {
                if (!valid1)
                    JOptionPane.showMessageDialog(null, "Invalid input for the polynomial!", "Error.", JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (pol2 != null)
                        JOptionPane.showMessageDialog(null, "Please introduce the polynomial in first textfield! ", "Error.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public boolean validatePolynomial(String input) {
        boolean valid = true;
        try {

            String monomialFormat = "([+-]?[\\d\\.]*[a-zA-Z]?\\^?\\d*)", monomialPartsFormat = "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)";

            Pattern p1 = Pattern.compile(monomialFormat);
            Matcher m1 = p1.matcher(input);

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

                }
            }

        } catch (Exception e) {
            System.out.println("~~Invalid polynomial~~");
            valid = false;
        }
        return valid;

    }

    public static boolean isNumeric(String str) {

        return str.matches("[+-]*\\d*\\.?\\d+");
    }

}
