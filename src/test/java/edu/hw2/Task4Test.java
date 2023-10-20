package edu.hw2;

import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.Task4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task4Test {
    CallingInfo testCaseMethod() {
        return Task4.callingInfo();
    }

    @Test
    void callingInfoOtherMethodTest() {
        CallingInfo testCase = testCaseMethod();
        Assertions.assertTrue(testCase.className().equals("edu.hw2.Task4Test") && testCase.methodName().equals("testCaseMethod"));
    }

    @Test
    void callingInfoThisMethodTest() {
        CallingInfo testCase = Task4.callingInfo();
        Assertions.assertTrue(testCase.className().equals("edu.hw2.Task4Test") && testCase.methodName().equals("callingInfoThisMethodTest"));
    }
}
