package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    @Test
    void simpleNestable() {
        int a1[] = {1, 2, 3, 4};
        int a2[] = {0, 6};
        boolean testResult = Task3.isNestable(a1, a2);
        assertEquals(true, testResult);
    }
    @Test
    void repitableNestable() {
        int a1[] = {1, 2, 2, 2};
        int a2[] = {0, 6};
        boolean testResult = Task3.isNestable(a1, a2);
        assertEquals(true, testResult);
    }
    @Test
    void shakedNestable() {
        int a1[] = {4, 2, 5, 3};
        int a2[] = {6, 1};
        boolean testResult = Task3.isNestable(a1, a2);
        assertEquals(true, testResult);
    }
    @Test
    void unnestable() {
        int a1[] = {9, 9, 8};
        int a2[] = {8, 9};
        boolean testResult = Task3.isNestable(a1, a2);
        assertEquals(false, testResult);
    }
}
