package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Hangman {
    private final String answer;
    private final int maxAttempts;
    private static final Logger LOGGER = LogManager.getLogger();
    Scanner scanner = new Scanner(System.in);

    public Hangman(String answer, int maxAttempts) {
        this.answer = answer;
        this.maxAttempts = maxAttempts;
    }

    private GuessResult tryGuess(Session session, String input) {
        Character letter = input.toLowerCase().charAt(0);
        return session.guess(letter);
    }

    private void printState(GuessResult guess) {
        LOGGER.info(guess.message());
    }

    public GuessResult run() {
        Session session = new Session(answer, maxAttempts);
        LOGGER.info("Guess a letter:");
        while (true) {
            String guess = scanner.nextLine();
            if (guess.equals("give up")) {
                printState(session.giveUp());
                return session.giveUp();
            }
            if (guess.length() != 1) {
                throw new IllegalArgumentException("Expected \"char\", but not \"String\".");
            }
            GuessResult result = tryGuess(session, guess);
            if (result instanceof Win || result instanceof Defeat) {
                printState(result);
                return result;
            }
            printState(result);
        }
    }
}

