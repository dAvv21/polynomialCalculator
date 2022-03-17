package models;

public class Monomial {
    private double coefficient;
    private final int degree;
    public boolean goThrough;

    public Monomial(double coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
        goThrough = true;
    }

    public double getCoefficient() {
        return this.coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return this.degree;
    }


}
