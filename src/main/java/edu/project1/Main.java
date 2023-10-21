package edu.project1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int SEED_FOR_RANDOM_FOR_LIBRARY_WORD = 7;
        final int MAX_COUNT_OF_ATTEMPTS = 6;
        Hangman hangman = new Hangman(new WordGenerator(new Random(SEED_FOR_RANDOM_FOR_LIBRARY_WORD)).randomWord(),
            MAX_COUNT_OF_ATTEMPTS);
        hangman.run();
    }
}
