package edu.hw1;

import java.util.Arrays;

final public class Task6 {
    private Task6() {}

    private static int kaprekarFn(int n) {
        int[] digits = new int[] {0, 0, 0, 0};
        int big = 0;
        int small = 0;
        int temp = n;
        final int THREE = 3;
        final int FOUR = 4;
        final int TEN = 10;
        for (int i = 0; i < FOUR && temp > 0; i++) {
            digits[i] = temp % TEN;
            temp /= TEN;
        }
        Arrays.sort(digits);
        for (int i = 0; i < FOUR; i++) {
            small += digits[i] * (int) Math.pow(TEN, THREE - i);
            big += digits[THREE - i] * (int) Math.pow(TEN, THREE - i);
        }
        return big - small;
    }

    public static int countK(int n) {
        final int kaprekarNum = 6174;
        if (n != kaprekarNum) {
            return 1 + countK(kaprekarFn(n));
        }
        return 0;
    }
}
