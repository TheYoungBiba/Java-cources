package edu.hw10.task2.fibonacci;

import edu.hw10.task2.Cache;

public interface FibCalculator {
    @Cache(persist = false)
    long fib(int number);
}
