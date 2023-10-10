package edu.hw1;

import java.util.IllformedLocaleException;

final public class Task1 {
    private Task1() {}
    private boolean isValidInput(String time) {
        Character colon = time.charAt(time.length() - 3);
        return colon.equals(':');
    }
    public int minutesToSeconds(String time) {
        if (!isValidInput(time))
            throw new IllformedLocaleException();
        String seconds = time.substring(time.length() - 2);
        int countOfSeconds = Integer.parseInt(seconds);
        if (countOfSeconds > 59)
            return -1;
        String minutes = time.substring(0, time.length() - 3);
        int countOfMinutes = Integer.parseInt(minutes);
        return countOfMinutes * 60 + countOfSeconds;
    }
}
