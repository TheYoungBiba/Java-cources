package edu.hw1;

final public class Task5 {
    private Task5() {}

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static String getOffspring(String str) {
        String offspring = new String();
        for (int i = 0; i < str.length() - 1; i += 2) {
            Integer couple = Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(i + 1));
            offspring += couple.toString();
        }
        if (str.length() % 2 != 0) {
            offspring += str.charAt(str.length() - 1);
        }
        return offspring;
    }

    public static boolean isPalindromeDescendant(int n) {
        String str = String.valueOf(n);
        if (!isPalindrome(str)) {
            String offspring = getOffspring(str);
            if (offspring.length() > 1) {
                return isPalindromeDescendant(Integer.parseInt(offspring));
            }
        }
        if (isPalindrome(str)) {
            return true;
        }
        return false;
    }
}
