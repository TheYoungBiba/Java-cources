package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8Test {
    @ParameterizedTest
    @CsvSource({
        "01, false",
        "10, false",
        "11, false",
        "00, false",
        "0000, false",
        "0101010111, false",
        "0, true",
        "1, true",
        "111, true",
        "000101111, true",
    })
    void oddLengthTest(String testCase, boolean referent) {
        assertEquals(referent, Task8.oddLength(testCase));
    }

    @ParameterizedTest
    @CsvSource({
        "1, false",
        "111, false",
        "10110, false",
        "00, false",
        "0111, false",
        "00010111, false",
        "0, true",
        "011, true",
        "00110, true",
        "0011000, true",
        "10, true",
        "1111, true",
        "10010111, true",
        "1001011100, true",
    })
    void startDeterminateTest(String testCase, boolean referent) {
        assertEquals(referent, Task8.startDeterminate(testCase));
    }

    @ParameterizedTest
    @CsvSource({
        "111, false",
        "11, false",
        "1, true",
        "10110, true",
        "00, true",
        "0111, true",
        "00010111, true",
        "0, true",
        "00110, true",
        "0011000, true",
        "10, true",
        "1111, true",
        "10010111, true",
        "1001011100, true",
    })
    void zeroTreeTest(String testCase, boolean referent) {
        assertEquals(referent, Task8.zeroTree(testCase));
    }







    @ParameterizedTest
    @CsvSource({
        "111, false",
        "11, false",
        "1, true",
        "10110, true",
        "00, true",
        "0111, true",
        "00010111, true",
        "0, true",
        "00110, true",
        "0011000, true",
        "10, true",
        "1111, true",
        "10010111, true",
        "1001011100, true",
    })
    void not11Or111Test(String testCase, boolean referent) {
        assertEquals(referent, Task8.not11Or111(testCase));
    }
}
