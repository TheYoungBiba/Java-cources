package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void simpleCheck() {
        String testCase = "123456";
        String testResult = Task4.fixString(testCase);
        assertEquals("214365", testResult);
    }
    @Test
    void checkWithSymbols() {
        String testCase = "hTsii  s aimex dpus rtni.g";
        String testResult = Task4.fixString(testCase);
        assertEquals("This is a mixed up string.", testResult);
    }
    @Test
    void oddLengthSymbols() {
        String testCase = "badce";
        String testResult = Task4.fixString(testCase);
        assertEquals("abcde", testResult);
    }
}
