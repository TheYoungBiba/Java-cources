package edu.project1;

public class Session {
    private final String answer;
    private final int maxAttempts;
    private char[] userAnswer;
    private int attempts = 0;

    public Session(String answer, int maxAttempts) {
        this.answer = answer.toLowerCase();
        this.maxAttempts = maxAttempts;
        this.userAnswer = new char[answer.length()];
        for (int i = 0; i < userAnswer.length; i++) {
            userAnswer[i] = '\u0000';
        }
    }

    private void openLetter(Character letter) {
        for (int i = 0; i < answer.length(); i++) {
            if (letter.equals(answer.charAt(i))) {
                userAnswer[i] = letter;
            }
        }
    }

    public GuessResult guess(Character guess) {
        Character temp = Character.toLowerCase(guess);
        if (!Character.isLetter(temp)) {
            throw new IllegalArgumentException("The word includes only letters. The input with symbols is incorrect.");
        }
        if (answer.indexOf(temp) != -1) {
            openLetter(temp);
            if (new String(userAnswer).equals(answer)) {
                return new Win(userAnswer, attempts);
            }
            return new SuccessfulGuess(userAnswer, attempts);
        } else {
            attempts++;
            if (attempts == maxAttempts) {
                return new Defeat(answer, attempts);
            }
            return new FailedGuess(userAnswer, attempts);
        }
    }

    public GuessResult giveUp() {
        return new Defeat(answer, attempts);
    }
}
