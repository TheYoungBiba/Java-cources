package edu.hw3;

import java.util.LinkedList;

public class Task2 {
    private Task2() {}

    private static int countOfOccurrences(char symbol, String inString) {
        return inString.length() - inString.replace(((Character)symbol).toString(), "").length();
    }

    private static boolean isValid(String input) {
        int countOfOpenBruckets = countOfOccurrences('(', input);
        int countOfClosedBruckets = countOfOccurrences(')', input);
        return (countOfOpenBruckets == countOfClosedBruckets
            && input.charAt(0) == '(' && input.charAt(input.length() - 1) == ')');
    }

    private static int isClosedAt(int startIndex, String unclusterizedStr) {
        StringBuilder tempUnclusterizedStr = new StringBuilder(unclusterizedStr);
        if (tempUnclusterizedStr.charAt(startIndex) == ')') {
            return -1;
        }
        for (int i = startIndex + 1; i < tempUnclusterizedStr.length(); i++) {
            if (tempUnclusterizedStr.charAt(i) == ')') {
                for (int j = i - 1; j >= startIndex; j--) {
                    if (tempUnclusterizedStr.charAt(j) == '(') {
                        if (j == startIndex) {
                            return i;
                        }
                        else {
                            tempUnclusterizedStr.setCharAt(i, ']');
                            tempUnclusterizedStr.setCharAt(j, '[');
                        }
                        break;
                    }
                }
            }
        }
        return -1;
    }

    public static LinkedList<String> clusterize(String unclusterizedStr) {
        if (!isValid(unclusterizedStr)) {
            throw new IllegalArgumentException("Incorrect count of opened and closed brackets in input string.");
        }
        LinkedList<String> clusters = new LinkedList<>();
        StringBuilder tempUnclusterizedStr = new StringBuilder(unclusterizedStr);
        while (tempUnclusterizedStr.length() > 0) {
            int indexOfClose = isClosedAt(0, tempUnclusterizedStr.toString());
            if (indexOfClose == -1) {
                throw new IllegalArgumentException("Incorrect location of brackets in string.");
            }
            clusters.add(tempUnclusterizedStr.substring(0, indexOfClose + 1));
            tempUnclusterizedStr.delete(0, indexOfClose + 1);
        }
        return clusters;
    }
}
