package edu.project1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangmanTest {

    private Hangman callHangman(String testCase) {
        InputStream is = new ByteArrayInputStream(testCase.getBytes());
        System.setIn(is);
//      new WordGenerator(new Random(7)).randomWord() = "library"
//      т.к. этот псевдо-рандом вернет число 10, т.е. в массиве под этим индексом будет слово "library"
        return new Hangman(new WordGenerator(new Random(7)).randomWord(), 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"l\ni\nb\nr\na\ny", "L\ni\nb\nr\na\nR\ny"})
    void runWinTest(String testCase) {
        Hangman hangman = callHangman(testCase);
        assertTrue(hangman.run() instanceof Win);
    }

    @ParameterizedTest
    @ValueSource(strings = {"l\ni\nb\nr\na\nx\nx\nx\nx\nx\nx", "L\ni\nb\nr\na\nR\nx\nx\nx\nx\nx\nx", "give up"})
    void runDefeatTest(String testCase) {
        Hangman hangman = callHangman(testCase);
        assertTrue(hangman.run() instanceof Defeat);
    }

    @ParameterizedTest
    @ValueSource(strings = {"li\nb\n", "L\nbr\n"})
    void runExceptionTest(String  testCase) {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Hangman hangman = callHangman(testCase);
            hangman.run();
        });
        assertEquals("Expected \"char\", but not \"String\".", e.getMessage());
    }
}
