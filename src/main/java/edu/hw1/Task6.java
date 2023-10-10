package edu.hw1;

import java.sql.Array;
import java.util.Arrays;

final public class Task6 {
    private Task6() {}
    private int kaprekarFn(int var) {
        int[] digits = new int[] {0, 0, 0,  0};
        int big = 0, small = 0;
        for (int i = 0; i < 4 && var > 0; i++) {
            digits[i] = var % 10;
            var /= 10;
        }
        Arrays.sort(digits);
//        Arrays.sort(array, Collections.reverseOrder());
        for (int i = 0; i < 4; i++) {
            small += digits[i] * (int) Math.pow(10, 3 - i);
            big += digits[3 - i] * (int) Math.pow(10, 3 - i);
        }
        return big - small;
    }
    public int countK(int n) {
        if (n != 6174)
            return 1 + countK(kaprekarFn(n));
        return 0;
    }
}
