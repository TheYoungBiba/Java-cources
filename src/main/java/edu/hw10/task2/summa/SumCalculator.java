package edu.hw10.task2.summa;

import edu.hw10.task2.Cache;

public interface SumCalculator {
    @Cache(persist = true)
    int sum(int... values);
}
