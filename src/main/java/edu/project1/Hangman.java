package edu.project1;

import java.util.Scanner;

public class Hangman {
    Scanner scanner = new Scanner(System.in);
    private String answer = new WordGenerator().randomWord();
    private final int maxCountOfAttempts = 6;

    public Hangman() {}

    private boolean starter() {
        ConsoleDisplay.toStart();
        Character agree = scanner.next().toLowerCase().charAt(0);
        if (!agree.equals('y')) {
            System.exit(0);
        }
        return true;
    }

    public void toPlay() {
        if (starter()) {
            Session session = new Session(answer, maxCountOfAttempts);
            session.startSession();
        }
    }
}

