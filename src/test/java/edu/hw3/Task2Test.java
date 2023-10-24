package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @ParameterizedTest
    @ValueSource(strings = {"())(()", "()())(", ")(()()", "()(()"})
    void clusterizeExceptionTest(String testCase) {
        assertThrows(IllegalArgumentException.class, () -> {
            Task2.clusterize(testCase);
        });
    }

    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of("()()()", new LinkedList<String>().add("()", "()", "()")),
            Arguments.of()
        };
    }

    void
}
