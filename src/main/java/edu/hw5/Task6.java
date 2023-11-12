package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    private Task6() {}

    public static boolean subsequenceFinder(String s, String t) {
        Pattern subsequenceFinderPattern = Pattern.compile(s);
        Matcher matcher = subsequenceFinderPattern.matcher(t);
        return matcher.find();
    }
}
