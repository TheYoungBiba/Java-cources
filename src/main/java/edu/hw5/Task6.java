package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    private Task6() {}

    public static boolean subsequenceFinder(String S, String T) {
        Pattern subsequenceFinderPattern = Pattern.compile(S);
        Matcher matcher = subsequenceFinderPattern.matcher(T);
        return matcher.find();
    }
}
