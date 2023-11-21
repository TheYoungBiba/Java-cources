package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    private Task5() {}

    public static boolean isValidLicensePlate(String licensePlate) {
        Pattern licensePlatePattern = Pattern.compile("^([А-Я])(\\d{3})([А-Я]{2})(\\d{3})$");
        Matcher matcher = licensePlatePattern.matcher(licensePlate);
        return matcher.matches();
    }
}
