package edu.project1;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordGeneratorTest {
    @Test
    void randomWordTest() {
//      Этот псевдо-рандом вернет число 10, т.е. в массиве под этим индексом будет слово "library"
        Random randomIndex = new Random(7);
        WordGenerator testCase = new WordGenerator(randomIndex);
        assertEquals("library", testCase.randomWord());
    }
}
