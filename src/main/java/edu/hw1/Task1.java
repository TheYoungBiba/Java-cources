package edu.hw1;

import java.util.IllformedLocaleException;

final public class Task1 {
    private Task1() {}

    private static boolean isValidInput(String time) {
        final int THREE = 3;
        Character colon = time.charAt(time.length() - THREE);
        return colon.equals(':');
    }

    public static int minutesToSeconds(String time) {
        if (!isValidInput(time)) {
            throw new IllformedLocaleException();
        }
        final int TWO = 2;
        String seconds = time.substring(time.length() - TWO);
        int countOfSeconds = Integer.parseInt(seconds);
        final int maxCountOfSeconds = 59;
        if (countOfSeconds > maxCountOfSeconds) {
            return -1;
        }
        final int THREE = 3;
        String minutes = time.substring(0, time.length() - THREE);
        int countOfMinutes = Integer.parseInt(minutes);
        final int secondsPerMin = 60;
        return countOfMinutes * secondsPerMin + countOfSeconds;
    }
}
