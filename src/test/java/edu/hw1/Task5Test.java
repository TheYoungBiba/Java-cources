package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @Test
    void simpleCheck() {
        int testCase = 13001120;
        boolean testResult = Task5.isPalindromeDescendant(testCase);
        assertEquals(true, testResult);
    }
    @Test
    void checkWithTwoSymbols() {
        int testCase = 11211230;
        boolean testResult = Task5.isPalindromeDescendant(testCase);
        assertEquals(true, testResult);
    }
    @Test
    void straightCheckWithTwoSymbols() {
        int testCase = 11;
        boolean testResult = Task5.isPalindromeDescendant(testCase);
        assertEquals(true, testResult);
    }
    @Test
    void anotherCheckWithTwoSymbols() {
        int testCase = 10;
        boolean testResult = Task5.isPalindromeDescendant(testCase);
        assertEquals(false, testResult);
    }
    @Test
    void checkWithThreeSymbols() {
        int testCase = 364;
        boolean testResult = Task5.isPalindromeDescendant(testCase);
        assertEquals(false, testResult);
    }
}
