package edu.hw8.task2;

import java.util.List;
import java.util.Vector;

public class FibonacciCalculator {
    private FibonacciCalculator() {}

    @SuppressWarnings("MagicNumber")
    public static List<FibonacciNumber> parallelFibonacciCalc(int countOfValues) {
        List<FibonacciNumber> listOfFibonacciNumbers = new Vector<>();
        FixedThreadPool threadPool = new FixedThreadPool(4);
        threadPool.start();
        for (int i = 0; i < countOfValues; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                listOfFibonacciNumbers.add(new FibonacciNumber(finalI, fib(finalI)));
            });
        }
        threadPool.close();
        return listOfFibonacciNumbers;
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
