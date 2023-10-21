package edu.project1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SessionTest {
    Session testCase = new Session("Qwertyt", 6);

    @ParameterizedTest
    @ValueSource(chars = {'!', '@', '7', '*'})
    void guessExceptionTest(char testСhar) {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            testCase.guess(testСhar);
        });
        assertEquals("The word includes only letters. The input with symbols is incorrect.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(chars = {'T', 't', 'q', 'w', 'e', 'y'})
    void guessSuccessfulGuessTest(char testСhar) {
        GuessResult testResult = testCase.guess(testСhar);
        assertTrue(testResult instanceof SuccessfulGuess);
    }

    @Test
    void guessWinTest() {
        char[] filler = {'T', 't', 'q', 'w', 'e', 'y'};
        for (char fillerInput : filler) {
            testCase.guess(fillerInput);
        }
        GuessResult testResult = testCase.guess('r');
        assertTrue(testResult instanceof Win && ((Win) testResult).attempts() == 0);
    }

    @ParameterizedTest
    @ValueSource(chars = {'X', 'x', 'v', 'n', 'm', 'o'})
    void guessFailedGuessTest(char testСhar) {
        GuessResult testResult = testCase.guess(testСhar);
        assertTrue(testResult instanceof FailedGuess);
    }

    @Test
    void guessDefeatTest() {
        char[] filler = {'X', 'x', 'v', 'n', 'm'};
        for (char fillerInput : filler) {
            testCase.guess(fillerInput);
        }
        GuessResult testResult = testCase.guess('o');
        assertTrue(testResult instanceof Defeat && ((Defeat) testResult).attempts() == 6);
    }

    @ParameterizedTest
    @ValueSource(chars = {'T', 't'})
    void guessUserAnswerTest(char testChar) {
        GuessResult testResult = testCase.guess(testChar);
        assertEquals("\u0000\u0000\u0000\u0000t\u0000t", new String(((SuccessfulGuess) testResult).state()));
    }

    @Test
    void guessGiveUpTest() {
        GuessResult testResult = testCase.giveUp();
        assertTrue(testResult instanceof Defeat);
    }

//  new WordGenerator(new Random(7)).randomWord() = "library"
//  т.к. этот псевдо-рандом вернет число 10, т.е. в массиве под этим индексом будет слово "library"
    Session testCaseWithRandom = new Session(new WordGenerator(new Random(7)).randomWord(), 6);

    @ParameterizedTest
    @ValueSource(chars = {'!', '@', '7', '*'})
    void guessWithRandomExceptionTest(char testСhar) {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            testCaseWithRandom.guess(testСhar);
        });
        assertEquals("The word includes only letters. The input with symbols is incorrect.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(chars = {'l', 'i', 'B', 'r', 'r', 'A'})
    void guessWithRandomSuccessfulGuessTest(char testСhar) {
        GuessResult testResult = testCaseWithRandom.guess(testСhar);
        assertTrue(testResult instanceof SuccessfulGuess);
    }

    @Test
    void guessWithRandomWinTest() {
        char[] filler = {'l', 'i', 'B', 'r', 'r', 'A'};
        for (char fillerInput : filler) {
            testCaseWithRandom.guess(fillerInput);
        }
        GuessResult testResult = testCaseWithRandom.guess('y');
        assertTrue(testResult instanceof Win && ((Win) testResult).attempts() == 0);
    }

    @ParameterizedTest
    @ValueSource(chars = {'X', 'x', 'v', 'n', 'm', 'o'})
    void guessWithRandomFailedGuessTest(char testСhar) {
        GuessResult testResult = testCaseWithRandom.guess(testСhar);
        assertTrue(testResult instanceof FailedGuess);
    }

    @Test
    void guessWithRandomDefeatTest() {
        char[] filler = {'X', 'x', 'v', 'n', 'm'};
        for (char fillerInput : filler) {
            testCaseWithRandom.guess(fillerInput);
        }
        GuessResult testResult = testCaseWithRandom.guess('o');
        assertTrue(testResult instanceof Defeat && ((Defeat) testResult).attempts() == 6);
    }

    @ParameterizedTest
    @ValueSource(chars = {'R'})
    void guessWithRandomUserAnswerTest(char testChar) {
        GuessResult testResult = testCaseWithRandom.guess(testChar);
        String test = new String(((SuccessfulGuess) testResult).state());
        assertEquals("\u0000\u0000\u0000r\u0000r\u0000", test);
    }
}
