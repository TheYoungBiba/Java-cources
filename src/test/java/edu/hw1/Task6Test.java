package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    void simpleCheck1() {
        int testCase = 6621;
        int resultTest = Task6.countK(testCase);
        assertEquals(5, resultTest);
    }
    @Test
    void simpleCheck2() {
        int testCase = 6554;
        int resultTest = Task6.countK(testCase);
        assertEquals(4, resultTest);
    }
    @Test
    void simpleCheck3() {
        int testCase = 1234;
        int resultTest = Task6.countK(testCase);
        assertEquals(3, resultTest);
    }
    @Test
    void checkWithZero() {
        int testCase = 3504;
        int resultTest = Task6.countK(testCase);
        assertEquals(7, resultTest);
    }
    @Test
    void checkWithZeroes() {
        int testCase = 1001;
        int resultTest = Task6.countK(testCase);
        assertEquals(4, resultTest);
    }
}
