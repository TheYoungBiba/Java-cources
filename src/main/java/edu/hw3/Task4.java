package edu.hw3;

import java.util.HashMap;

public class Task4 {
    private Task4() {}

    private static HashMap<Integer, String> initRomanNumsHashMap() {
        final int[] arabianNumKeys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90,
            100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000};
        final String[] arabianNumsValues = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
            "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD", "D", "DC",
            "DCC", "DCCC", "CM", "M", "MM", "MMM"};
        HashMap<Integer, String> romanNums = new HashMap<>();
        for (int i = 0; i < arabianNumKeys.length; i++) {
            romanNums.put(arabianNumKeys[i], arabianNumsValues[i]);
        }
        return romanNums;
    }

    public static String convertToRoman(Integer arabianNum) {
        final int MAX_CORRECT_ARABIAN_NUMBER_IN_ROMAN_NUMBERS = 3999;
        if (arabianNum > MAX_CORRECT_ARABIAN_NUMBER_IN_ROMAN_NUMBERS) {
            throw new IllegalArgumentException("Max correct convertable value is 3999");
        }
        HashMap<Integer, String> romanNums = initRomanNumsHashMap();
        StringBuilder tempRomanNum = new StringBuilder();
        final int SHIFT_ON_ONE_TEN = 10;
        Integer tempArabianNum = arabianNum;
        for (int degree = 0; tempArabianNum > 0; degree++) {
            int key = tempArabianNum % SHIFT_ON_ONE_TEN * ((int) Math.pow(SHIFT_ON_ONE_TEN, degree));
            if (key != 0) {
                tempRomanNum.insert(0, romanNums.get(key));
            }
            tempArabianNum /= SHIFT_ON_ONE_TEN;
        }
        return tempRomanNum.toString();
    }
}
