package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task7Test {
    @Test
    void simpleCheckROR() {
        int testCaseNum = 8;
        int testCaseShift = 1;
        int testResult = Task7.rotateRight(testCaseNum, testCaseShift);
        assertEquals(4, testResult);
    }
    @Test
    void bigNumCheckROR() {
        int testCaseNum = 130;
        int testCaseShift = 7;
        int testResult = Task7.rotateRight(testCaseNum, testCaseShift);
        assertEquals(5, testResult);
    }
    @Test
    void bigShiftCheckROR() {
        int testCaseNum = 130;
        int testCaseShift = 15;
        int testResult = Task7.rotateRight(testCaseNum, testCaseShift);
        assertEquals(5, testResult);
    }
    @Test
    void simpleCheckROL() {
        int testCaseNum = 17;
        int testCaseShift = 2;
        int testResult = Task7.rotateLeft(testCaseNum, testCaseShift);
        assertEquals(6, testResult);
    }
    @Test
    void bigNumCheckROL() {
        int testCaseNum = 142;
        int testCaseShift = 6;
        int testResult = Task7.rotateLeft(testCaseNum, testCaseShift);
        assertEquals(163, testResult);
    }
    @Test
    void bigShiftCheckROL() {
        int testCaseNum = 142;
        int testCaseShift = 14;
        int testResult = Task7.rotateLeft(testCaseNum, testCaseShift);
        assertEquals(163, testResult);
    }
}
