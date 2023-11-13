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
        "1, false",
        "10110, false",
        "00, false",
        "0111, false",
        "0, false",
        "0011000, false",
        "10, false",
        "1111, false",
        "1001011100, false",
        "00110, true",
        "0001111, true",
        "10010111, true",
        "10010111000, true"
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
        "11111, true",
        "10010111, true",
        "1001011100, true",
    })
    void not11Or111Test(String testCase, boolean referent) {
        assertEquals(referent, Task8.not11Or111(testCase));
    }

    @ParameterizedTest
    @CsvSource({
        "00, false",
        "0111, false",
        "00010111, false",
        "0, false",
        "00110, false",
        "0011000, false",
        "10110111, false",
        "1001011100, false",
        "1, true",
        "101111, true",
        "10, true",
        "1111, true",
        "111, true",
        "11, true",
    })
    void oddIndexEq1Test(String testCase, boolean referent) {
        assertEquals(referent, Task8.oddIndexEq1(testCase));
    }

    @ParameterizedTest
    @CsvSource({
        "00, true",
        "100, true",
        "010, true",
        "001, true",
        "0000000, true",
        "00000010000, true",
        "10, false",
        "1, false",
        "0111, false",
        "00010111, false",
        "00110, false",
        "0011000, false",
        "10110111, false",
        "1001011100, false",
    })
    void containsTwo0One1Test(String testCase, boolean referent) {
        assertEquals(referent, Task8.containsTwo0One1(testCase));
    }

    @ParameterizedTest
    @CsvSource({
        "1, true",
        "0, true",
        "10000, true",
        "00001, true",
        "0000100, true",
        "00, true",
        "11, false",
        "111, false",
        "11, false",
        "10110, false",
        "0111, false",
        "00010111, false",
        "00110, false",
        "0011000, false",
        "11111, false",
        "10010111, false",
        "1001011100, false",
    })
    void notStreamOf1Test(String testCase, boolean referent) {
        assertEquals(referent, Task8.notStreamOf1(testCase));
    }
}
