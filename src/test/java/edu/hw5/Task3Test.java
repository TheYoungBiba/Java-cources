package edu.hw5;

import edu.hw5.task3.DaysParser;
import edu.hw5.task3.HyphenParser;
import edu.hw5.task3.Parser;
import edu.hw5.task3.SlashParser;
import edu.hw5.task3.WordParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    private static Stream<Arguments> provideArgumentsForHyphenParserTest() {
        return Stream.of(
            Arguments.of("2020-10-10", Optional.of(LocalDate.of(2020, 10, 10))),
            Arguments.of("2020-12-2", Optional.of(LocalDate.of(2020, 12, 2))),
            Arguments.of("2020-1-10", Optional.of(LocalDate.of(2020, 1, 10))),
            Arguments.of("2020-1-2", Optional.of(LocalDate.of(2020, 1, 2))),
            Arguments.of("2020--1-2", Optional.empty()),
            Arguments.of("2020-1--2", Optional.empty()),
            Arguments.of("2020-1", Optional.empty()),
            Arguments.of("2020 1 2", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForHyphenParserTest")
    void hyphenParserTest(String testCase, Optional referent) {
        assertEquals(referent, new HyphenParser().parseDate(testCase));
    }

    private static Stream<Arguments> provideArgumentsForSlashParserTest() {
        return Stream.of(
            Arguments.of("1/3/1976", Optional.of(LocalDate.of(1976, 3, 1))),
            Arguments.of("1/3/20", Optional.of(LocalDate.of(2020, 3, 1))),
            Arguments.of("1/12/0020", Optional.of(LocalDate.of(20, 12, 1))),
            Arguments.of("1/3/23", Optional.of(LocalDate.of(2023, 3, 1))),
            Arguments.of("1/3/24", Optional.of(LocalDate.of(1924, 3, 1))),
            Arguments.of("11/3/99", Optional.of(LocalDate.of(1999, 3, 11))),
            Arguments.of("11/3/00", Optional.of(LocalDate.of(2000, 3, 11))),
            Arguments.of("2020-1-2", Optional.empty()),
            Arguments.of("1-3-1976", Optional.empty()),
            Arguments.of("1976/3/1", Optional.empty()),
            Arguments.of("1 3 1976", Optional.empty()),
            Arguments.of("1//1976", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForSlashParserTest")
    void slashParserTest(String testCase, Optional referent) {
        assertEquals(referent, new SlashParser().parseDate(testCase));
    }

    private static Stream<Arguments> provideArgumentsForWordParserTest() {
        return Stream.of(
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("today", Optional.of(LocalDate.now())),
            Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("qwerty", Optional.empty()),
            Arguments.of("ttoday", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForWordParserTest")
    void wordParserTest(String testCase, Optional referent) {
        assertEquals(referent, new WordParser().parseDate(testCase));
    }

    private static Stream<Arguments> provideArgumentsForDaysParserTest() {
        return Stream.of(
            Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("2234 days ago", Optional.of(LocalDate.now().minusDays(2234))),
            Arguments.of("1day ago", Optional.empty()),
            Arguments.of("1 ago", Optional.empty()),
            Arguments.of("1 dayAgo", Optional.empty()),
            Arguments.of("a day ago", Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForDaysParserTest")
    void daysParserTest(String testCase, Optional referent) {
        assertEquals(referent, new DaysParser().parseDate(testCase));
    }

    private static Stream<Arguments> provideArgumentsForParserTest() {
        return Stream.of(
            Arguments.of("2020-10-10", Optional.of(LocalDate.parse("2020-10-10"))),
            Arguments.of("2020-12-2", Optional.of(LocalDate.parse("2020-12-02"))),
            Arguments.of("1/3/1976", Optional.of(LocalDate.parse("1976-03-01"))),
            Arguments.of("1/3/20", Optional.of(LocalDate.parse("2020-03-01"))),
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("today", Optional.of(LocalDate.now())),
            Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("4 days ago", Optional.of(LocalDate.now().minusDays(4)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForParserTest")
    void parserTest(String testCase, Optional referent) {
        assertEquals(referent, Parser.parseDate(testCase));
    }
}
