package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    void Zero() {
        int testCase = 0;
        int testResult = Task2.countDigits(testCase);
        assertEquals(1, testResult);
    }
    @Test
    void negativeNumber() {
        int testCase = -123;
        int testResult = Task2.countDigits(testCase);
        assertEquals(3, testResult);
    }
    @Test
    void baseTest() {
        int testCase = 4666;
        int testResult = Task2.countDigits(testCase);
        assertEquals(4, testResult);
    }
}
