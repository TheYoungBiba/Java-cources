package edu.hw1;

final public class Task4 {
    private Task4 () {}
    public String fixString(String str) {
        char[] arrOfChars = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i += 2) {
            char temp = arrOfChars[i];
            arrOfChars[i] = arrOfChars[i + 1];
            arrOfChars[i + 1] = temp;
        }
        str = new String(arrOfChars);
        return str;
    }
}
