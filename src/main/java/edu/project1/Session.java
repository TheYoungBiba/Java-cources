package edu.project1;

import java.util.Scanner;

public class Session {
    private String answer;
    private int maxCountOfAttempts;
    private char[] userAnswer;
    private int currentCountOfAttempts;

    public Session(String answer, int maxCountOfAttempts) {
        this.answer = answer.toLowerCase();
        this.maxCountOfAttempts = maxCountOfAttempts;
        this.currentCountOfAttempts = maxCountOfAttempts;
        this.userAnswer = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            userAnswer[i] = '*';
        }
    }

    private boolean isAnswered(char[] userAnswer) {
        return new String(userAnswer).equals(answer);
    }

    private void openLetter(char rightLetter) {
        for (int i = 0; i < answer.length(); i++) {
            Character temp = answer.charAt(i);
            if (temp.equals(rightLetter)) {
                userAnswer[i] = temp;
            }
        }
    }

    public void startSession() {
        ConsoleDisplay.startMessage(new String(userAnswer), maxCountOfAttempts);
        Scanner scanner = new Scanner(System.in);
        char letter;
        while (!isAnswered(userAnswer) && currentCountOfAttempts > 0) {
            String tempStr = scanner.next();
            if (tempStr.equals("!!!")) {
                break;
            }
            letter = Character.toLowerCase(tempStr.charAt(0));
            if (answer.indexOf(letter) != -1) {
                openLetter(letter);
                ConsoleDisplay.rightGuessMessage(new String(userAnswer), currentCountOfAttempts);
            } else {
                currentCountOfAttempts--;
                ConsoleDisplay.wrongGuessMessage(new String(userAnswer), currentCountOfAttempts);
            }
        }
        if (isAnswered(userAnswer)) {
            ConsoleDisplay.winMessage(answer);
        } else {
            ConsoleDisplay.looseMessage(answer);
        }
    }
}
