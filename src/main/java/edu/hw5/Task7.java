package edu.hw5;

public class Task7 {
    private Task7() {}

    public static boolean lengthThreeThirdNull(String input) {
        return input.matches("^([0,1]{2})0([0,1]*)");
    }

    public static boolean sameBeginningAndEnding(String input) {
        return input.matches("(^0([0,1]*)0$)|(^1([0,1]*)1$)|^[0,1]$");
    }

    public static boolean lengthOneLessFour(String input) {
        return input.matches("[0,1]{1,3}");
    }
}
