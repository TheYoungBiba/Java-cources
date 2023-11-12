package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    private Task4() {}

    public static boolean isValidPassword(String password) {
        Pattern specSymbolPattern = Pattern.compile("(\\S*)([~!@#$%^&*|])(\\S*)");
        Matcher match = specSymbolPattern.matcher(password);
        return match.matches();
    }
}
