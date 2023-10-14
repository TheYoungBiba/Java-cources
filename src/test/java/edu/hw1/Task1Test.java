package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void Minute1() {
        String testCase = "01:00";
        int testResult = Task1.minutesToSeconds(testCase);
        assertEquals(60, testResult);
    }
    @Test
    void Minutes123Seconds45() {
        String testCase = "123:45";
        int testResult = Task1.minutesToSeconds(testCase);
        assertEquals(7425, testResult);
    }
    @Test
    void Seconds61() {
        String testCase = "15:61";
        int testResult = Task1.minutesToSeconds(testCase);
        assertEquals(-1, testResult);
    }
}
