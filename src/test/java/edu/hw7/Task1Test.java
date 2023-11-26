package edu.hw7;

import edu.hw7.task1.Counter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @ParameterizedTest
    @CsvSource("100_000, 100_000, 1000_000, 1000_000, 1234_5678, 1234_5678, 1234_5679, 1234_5679")
    void counterTest(int referent, int testCase) {
        Counter teestCounter = new Counter();
        teestCounter.targetIncrement(testCase);
        assertEquals(referent, teestCounter.get());
    }
}
