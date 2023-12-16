package edu.hw8;

import edu.hw8.task2.FibonacciCalculator;
import edu.hw8.task2.FibonacciNumber;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    private static Stream<Arguments> provideArgumentsForFibonacciCalculatorTest() {
        List<FibonacciNumber> referent1 = List.of(
            new FibonacciNumber(0, 0),
            new FibonacciNumber(1, 1),
            new FibonacciNumber(2, 1),
            new FibonacciNumber(3, 2),
            new FibonacciNumber(4, 3),
            new FibonacciNumber(5, 5),
            new FibonacciNumber(6, 8),
            new FibonacciNumber(7, 13),
            new FibonacciNumber(8, 21),
            new FibonacciNumber(9, 34)
        );
        List<FibonacciNumber> referent2 = List.of(
            new FibonacciNumber(0, 0),
            new FibonacciNumber(1, 1),
            new FibonacciNumber(2, 1)
        );
        return Stream.of(
            Arguments.of(referent1, 10),
            Arguments.of(referent2, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForFibonacciCalculatorTest")
    void FibonacciCalculatorTest(List<FibonacciNumber> referent, int testCase) {
        assertEquals(referent, FibonacciCalculator.parallelFibonacciCalc(testCase).stream()
            .sorted(Comparator.comparingInt(FibonacciNumber::start))
            .toList());
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "13, 7", "-1, -1"})
    void fibTest(int referent, int testCase) {
        assertEquals(referent, FibonacciCalculator.fib(testCase));
    }
}
