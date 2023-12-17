package edu.hw10.task2.summa;

import java.util.Arrays;

public class Summa implements SumCalculator {
    @Override
    public int sum(int... values) {
        return Arrays.stream(values).sum();
    }
}
