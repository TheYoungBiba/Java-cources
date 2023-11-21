package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @ParameterizedTest
    @CsvSource(value = {"1925: [1925-02-13, 1925-03-13, 1925-11-13]", "2024: [2024-09-13, 2024-12-13]"},
               delimiter = ':')
    void fridayThe13thTest(int testCase, String referent) {
        assertEquals(Task2.fridayThe13th(testCase), referent);
    }

    private static Stream<Arguments> provideArgumentsForFindFirstFridayThe13thTest() {
        return Stream.of(
            Arguments.of(LocalDate.of(2023, 11, 11),
                LocalDate.of(2024, 9, 13)),
            Arguments.of(LocalDate.of(2023, 1, 29),
                LocalDate.of(2023, 10, 13)),
            Arguments.of(LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 1, 13))
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForFindFirstFridayThe13thTest")
    void findFirstFridayThe13thTest(LocalDate testCase, LocalDate referent) {
        assertEquals(Task2.findFirstFridayThe13th(testCase), referent);
    }
}
