package edu.hw3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @ParameterizedTest
    @ValueSource(strings = {"()())(", ")(()()", "()(()"})
    void clusterizeFirstStepOfValidationTest(String testCase) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Task2.clusterize(testCase);
        });
        assertEquals("Incorrect count of opened and closed brackets in input string.", e.getMessage());
    }

    @Test
    void clusterisizwIncorrectLocOfBrckts() {
        String testCase = "())(()";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Task2.clusterize(testCase);
        });
        assertEquals("Incorrect location of brackets in string.", e.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = {"()()():[(), (), ()]",
                "((())):[((()))]",
                "((()))(())()()(()()):[((())), (()), (), (), (()())]",
                "((())())(()(()())):[((())()), (()(()()))]",
                "(q(w(e)r)t(y)3)(q(w)e(r(t)y(0)1)2):[(q(w(e)r)t(y)3), (q(w)e(r(t)y(0)1)2)]"},
                delimiter = ':')
    void clusterizeSimpleTest(String testCase, String referent) {
        String testResult = Task2.clusterize(testCase).toString();
        assertEquals(referent, testResult);
    }
}
