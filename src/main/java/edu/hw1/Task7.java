package edu.hw1;

public class Task7 {
    private Task7() {}
    public static int rotateRight(int val, int shift) {
        String binStr = Integer.toBinaryString(val);
        if (shift > binStr.length())
            while (shift > binStr.length())
                shift -= binStr.length();
        String shiftedRightNum = binStr.substring(binStr.length() - shift) + binStr.substring(0, binStr.length() - shift);
        return Integer.parseInt(shiftedRightNum, 2);
    }
    public static int rotateLeft(int val, int shift) {
        String binStr = Integer.toBinaryString(val);
        if (shift > binStr.length())
            while (shift > binStr.length())
                shift -= binStr.length();
        String shiftedLeftNum = binStr.substring(shift) + binStr.substring(0, shift);
        return Integer.parseInt(shiftedLeftNum, 2);
    }
}
