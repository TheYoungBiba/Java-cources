package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    private static Stream<Arguments> provideArgumentsForMedianTimeSimpleTest() {
        String test1 = "2022-03-12, 20:20 - 2022-03-12, 23:50";
        String test2 = "2022-04-01, 21:30 - 2022-04-02, 01:20";
        String test3 = "2022-05-07, 13:00 - 2022-05-08, 00:00";
        String test4 = "2022-05-07, 13:00 - 2022-05-08, 00:01";
        List<String> testCase1 = new LinkedList<>();
        Collections.addAll(testCase1, test1, test2, test3);
        List<String> testCase2= new LinkedList<>();
        Collections.addAll(testCase2, test1, test2, test4);
        return Stream.of(
            Arguments.of(testCase1, "6ч 6м"),
            Arguments.of(testCase2, "6ч 7м")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForMedianTimeSimpleTest")
    void medianTimeSimpleTest(Collection<String> testCase, String referent) {
        assertEquals(referent, Task1.medianTime(testCase));
    }

    @Test
    void medianTimeExceptionTest() {
        String test1 = "2022-03-12, 9:20 - 2022-03-12, 23:50";
        String test2 = "2022-04-01, 21:30 - 2022-04-02, 01:20";
        String test3 = "2022-05-07, 13:00 - 2022-05-08, 00:00";
        List<String> testCase = new LinkedList<>();
        Collections.addAll(testCase, test1, test2, test3);
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Task1.medianTime(testCase);
        });
        assertEquals("Incorrect format of session.", e.getMessage());
    }
}
