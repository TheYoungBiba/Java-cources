package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @DisplayName("Factorial standard test")
    @ParameterizedTest
    @CsvSource({
        "-1, 0",
        "0, 0",
        "1, 1",
        "2, 2",
        "3, 6",
        "6, 720",
        "10, 3628800",
        "15, 1307674368000",
        "20, 2432902008176640000"
    })
    void factorialStandardTest(int testCase, long referent) {
        assertEquals(referent, Task2.factorial(testCase));
    }

    @DisplayName("Factorial exception test")
    @ParameterizedTest
    @ValueSource(ints = {21, 22, 30, 100})
    void factorialExceptionTest(int testCase) {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Task2.factorial(testCase);
        });
        assertEquals("Too big value.", e.getMessage());
    }
}
