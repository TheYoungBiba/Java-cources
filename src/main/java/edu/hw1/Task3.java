package edu.hw1;

import java.util.Arrays;

final public class Task3 {
    private Task3 () {}
    public boolean isNestable(int[] a1, int[] a2) {
//        Знаю, что можно было использовать "Arrays.stream(a1).min().getAsInt()", но пока не вполне разобрался со стримами
//        и не хочу писать невполне понятный для меня код.
        Arrays.sort(a1);
        Arrays.sort(a2);
        if ((a1[0] > a2[0]) && (a1[a1.length - 1] < a2[a2.length - 1]))
            return true;
        return false;
    }
}
