package edu.hw2;

import edu.hw2.task1.Addition;
import edu.hw2.task1.Constant;
import edu.hw2.task1.Exponent;
import edu.hw2.task1.Multiplication;
import edu.hw2.task1.Negate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


public class Task1Test {
    @ParameterizedTest
    @ValueSource(doubles = {-1, 2, 3})
    void constantTest(double value) {
        Assertions.assertEquals(value, new Constant(value).evaluate());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 2, 3})
    void negateTest(double value) {
        Constant toNegate = new Constant(value);
        Assertions.assertEquals(-value, new Negate(toNegate).evaluate());
    }

    @ParameterizedTest
    @CsvSource(value = {"-1, 2", "3, 4"}, ignoreLeadingAndTrailingWhitespace = true)
    void additionTest(double a, double b) {
        Assertions.assertEquals(a + b, new Addition(new Constant(a), new Constant(b)).evaluate());
    }

    @ParameterizedTest
    @CsvSource(value = {"-1, 2", "3, 4"}, ignoreLeadingAndTrailingWhitespace = true)
    void multiplicationTest(double a, double b) {
        Assertions.assertEquals(a * b, new Multiplication(new Constant(a), new Constant(b)).evaluate());
    }

    @ParameterizedTest
    @CsvSource(value = {"-1, 2", "3, 4"}, ignoreLeadingAndTrailingWhitespace = true)
    void exponentDefaultTest(double a, double b) {
        Assertions.assertEquals(Math.pow(a, b), new Exponent(new Constant(a), new Constant(b)).evaluate());
    }

    @ParameterizedTest
    @CsvSource(value = {"-1, 2", "3, 4"}, ignoreLeadingAndTrailingWhitespace = true)
    void exponentOverloadedTest(double a, double b) {
        Assertions.assertEquals(Math.pow(a, b), new Exponent(new Constant(a), b).evaluate());
    }

    @Test
    void exponentExceptionTest() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Exponent(new Constant(-7.525), 1.490).evaluate();
        });
        assertEquals("Incorrect input (exception: -7.525 and 1.490).", e.getMessage());
    }
}
