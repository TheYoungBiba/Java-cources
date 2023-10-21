package edu.temp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

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

    public void run() {
        boolean gameStarted = true;
        while (gameStarted) {
            Session session = new Session(answer, maxAttempts);
            boolean playing = true;
            while (playing) {
                String guess = scanner.nextLine();
                switch (guess) {
                    case ("give up"): {
                        printState(session.giveUp());
                        playing = false;
                        break;
                    }
                    case ("exit"): {
                        playing = false;
                        gameStarted = false;
                        break;
                    }
                }
                GuessResult result = tryGuess(session, guess);
                if (result instanceof Win || result instanceof Defeat) {
                    printState(result);
                    break;
                }
                printState(result);
            }
        }
    }
}
