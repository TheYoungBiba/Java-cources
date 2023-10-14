package edu.hw1;

final public class Task2 {
    private Task2() {}

    public static int countDigits(int number) {
        int count = 0;
        final int TEN = 10;
        if (number == 0) {
            return 1;
        }
        int temp = Math.abs(number);
        while (temp > 0) {
            temp /= TEN;
            count++;
        }
        return count;
    }
}
