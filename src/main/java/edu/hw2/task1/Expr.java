package edu.hw2.task1;

public sealed interface Expr permits Constant, Negate, Addition, Multiplication, Exponent {
    double evaluate();

//    public record Constant(double value) implements Expr {
//        @Override
//        public double evaluate() {
//            return value;
//        }
//    }

//    public record Negate(Expr value) implements Expr {
//        @Override
//        public double evaluate() {
//            return -value.evaluate();
//        }
//    }

//    public record Addition(Expr firstValue, Expr secondValue) implements Expr {
//        @Override
//        public double evaluate() {
//            return firstValue.evaluate() + secondValue.evaluate();
//        }
//    }

//    public record Multiplication(Expr firstValue, Expr secondValue) implements Expr {
//        @Override
//        public double evaluate() {
//            return firstValue.evaluate() * secondValue.evaluate();
//        }
//    }

//    public record Exponent(Expr value, double degree) implements Expr {
//        public Exponent(Expr value, Expr degree) {
//            this(value, degree.evaluate());
//        }
//        @Override
//        public double evaluate() {
//            return Math.pow(value.evaluate(), degree);
//        }
//    }
}
