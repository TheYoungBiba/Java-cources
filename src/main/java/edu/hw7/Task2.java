package edu.hw7;

import java.util.stream.LongStream;

public class Task2 {
    private Task2() {}

    public static long factorial(int n) {
        if (n > 20) {
            throw new IllegalArgumentException("Too big value.");
        }

        return LongStream.range(1, n + 1)
            .parallel()
            .reduce((left, right) -> left * right)
            .orElse(0L);

//      На случай, если необходимо было использовать функцию именно parallelStream

//        return LongStream.range(1, n + 1)
//            .boxed()
//            .toList()
//            .parallelStream()
//            .reduce((integer1, integer2) -> integer1 * integer2)
//            .orElse(0L);
    }
}
