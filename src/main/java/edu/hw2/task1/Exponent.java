package edu.hw2.task1;

public record Exponent(Expr value, double degree) implements Expr {
    public Exponent(Expr value, Expr degree) {
        this(value, degree.evaluate());
    }
    @Override
    public double evaluate() {
        return Math.pow(value.evaluate(), degree);
    }
}
