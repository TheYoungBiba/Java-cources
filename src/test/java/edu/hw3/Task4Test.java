package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @ParameterizedTest
    @CsvSource({"2036, MMXXXVI", "3999, MMMCMXCIX", "123, CXXIII", "2, II", "12, XII", "16, XVI"})
    void convertToRomanTest(int testCase, String referent) {
        assertEquals(referent, Task4.convertToRoman(testCase));
    }

    @ParameterizedTest
    @ValueSource(ints = {4000, 5111, 4001})
    void convertToRomanWithExceptionTest(int testCase) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Task4.convertToRoman(testCase);
        });
        assertEquals("Max correct convertable value is 3999", e.getMessage());
    }
}
