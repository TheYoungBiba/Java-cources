package edu.hw11;

import edu.hw11.task3.FibonacciClassFactory;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    void shouldReturnCorrectFibonacciNumbers() throws Exception {
        Class<?> testCase = FibonacciClassFactory.create();
        Method fib = testCase.getMethod("fib", int.class);
        List<Long> testResult = new LinkedList<>();
        for (int i = 0; i < 13; i++) {
            testResult.add(((Long) fib.invoke(null, i)));
        }
        List<Long> referent = List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L);
        assertEquals(referent, testResult);
    }
}
