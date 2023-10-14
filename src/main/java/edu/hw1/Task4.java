package edu.hw1;

final public class Task4 {
    private Task4() {}

    public static String fixString(String str) {
        String tempStr;
        char[] arrOfChars = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i += 2) {
            char temp = arrOfChars[i];
            arrOfChars[i] = arrOfChars[i + 1];
            arrOfChars[i + 1] = temp;
        }
        tempStr = new String(arrOfChars);
        return tempStr;
    }
}
