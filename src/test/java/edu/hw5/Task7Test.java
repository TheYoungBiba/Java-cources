package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @ParameterizedTest
    @CsvSource({
        "0, false",
        "01, false",
        "011, false",
        "01100001, false",
        "12011, false",
        "110, true",
        "10010101010, true"
    })
    void lengthThreeThirdNullTest(String testCase, boolean referent) {
        assertEquals(referent, Task7.lengthThreeThirdNull(testCase));
    }

    @ParameterizedTest
    @CsvSource({
        "01, false",
        "011, false",
        "01100001, false",
        "0, true",
        "1, true",
        "00, true",
        "11, true",
        "101, true",
        "0111111100000, true"
    })
    void sameBeginningAndEndingTest(String testCase, boolean referent) {
        assertEquals(referent, Task7.sameBeginningAndEnding(testCase));
    }

    @ParameterizedTest
    @CsvSource({
        "01, true",
        "011, true",
        "01100001, false",
        "0, true",
        "1, true",
        "00, true",
        "11, true",
        "101, true",
        "0111111100000, false",
        "0000, false"
    })
    void lengthOneLessFourTest(String testCase, boolean referent) {
        assertEquals(referent, Task7.lengthOneLessFour(testCase));
    }
}
