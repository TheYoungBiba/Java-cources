package edu.hw5;

public class Task8 {
    private Task8() {}

    public static boolean oddLength(String input) {
        return input.matches("^[0,1]([0,1]{2})*$");
    }

    public static boolean startDeterminate(String input) {
        return input.matches("^(0([0,1]{2})*)|(1[0,1]([0,1]{2})*)$");
    }

    public static boolean zeroTree(String input) {
        return input.matches("^((1*)0(1*)0(1*)0(1*))+$");
    }

    public static boolean not11Or111(String input) {
        return !input.matches("^(11|111)$");
    }

    public static boolean oddIndexEq1(String input) {
        return input.matches("^(1[0,1])+|1([0,1]1)*$");
    }

    public static boolean containsTwo0One1(String input) {
        return input.matches("^0*(100|010|001|00)0*$");
    }

    public static boolean notStreamOf1(String input) {
        return input.matches("^0|1|(0+[0,1])+|([0,1]0+)+$");
    }
}
