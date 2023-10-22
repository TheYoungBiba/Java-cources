package edu.hw2.task1;

public record Multiplication(Expr firstValue, Expr secondValue) implements Expr {
    @Override
    public double evaluate() {
        return firstValue.evaluate() * secondValue.evaluate();
    }
}
