package edu.hw10.task2.fibonacci;

public class Fibonacci implements FibCalculator {
    @Override
    public long fib(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fib(number - 2) + fib(number - 1);
    }
}
