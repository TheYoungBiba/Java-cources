package edu.hw1;

public class Task7 {
    private Task7() {}

    public static int rotateRight(int val, int shift) {
        String binStr = Integer.toBinaryString(val);
        int temp = shift;
        if (temp > binStr.length()) {
            while (temp > binStr.length()) {
                temp -= binStr.length();
            }
        }
        String shiftedRightNum = binStr.substring(binStr.length() - temp) + binStr.substring(0, binStr.length() - temp);
        return Integer.parseInt(shiftedRightNum, 2);
    }

    public static int rotateLeft(int val, int shift) {
        String binStr = Integer.toBinaryString(val);
        int temp = shift;
        if (temp > binStr.length()) {
            while (temp > binStr.length()) {
                temp -= binStr.length();
            }
        }
        String shiftedLeftNum = binStr.substring(temp) + binStr.substring(0, temp);
        return Integer.parseInt(shiftedLeftNum, 2);
    }
}
