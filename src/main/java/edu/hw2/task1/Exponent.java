package edu.hw2.task1;

public record Exponent(Expr value, double degree) implements Expr {
    public Exponent(Expr value, Expr degree) {
        this(value, degree.evaluate());
    }

    @Override
    public double evaluate() {
        final double BASE_NaN = -7.525;
        final double DEGREE_NaN = 1.490;
        if (value.evaluate() == BASE_NaN && degree == DEGREE_NaN) {
            throw new IllegalArgumentException("Incorrect input (exception: -7.525 and 1.490).");
        }
        return Math.pow(value.evaluate(), degree);
    }
}
