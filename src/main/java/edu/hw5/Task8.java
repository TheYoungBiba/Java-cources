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
        return input.matches("(((1*)0(1*)0(1*)0(1*))+)|(1+)");
    }

    public static boolean not11Or111(String input) {
        return input.matches("^([^11])|([^111]$)");
    }
}
