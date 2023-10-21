package edu.temp;

public class Session {
    private final String answer;
    private final int maxAttempts;
    private char[] userAnswer;
    private int attempts = 0;

    public Session(String answer, int maxAttempts) {
        this.answer = answer.toLowerCase();
        this.maxAttempts = maxAttempts;
        this.userAnswer = new char[answer.length()];
        for (char emtyLetter: userAnswer) {
            emtyLetter = '*';
        }
    }

    public GuessResult guess(Character guess) {
        guess = Character.toLowerCase(guess);
        if(!Character.isLetter(guess)) {
            throw new IllegalArgumentException("The word includes only letters. The input with symbols is incorrect.");
        }
        if(answer.indexOf(guess) != -1) {
            for(int i = 0; i < answer.length(); i++) {
                if(guess.equals(answer.charAt(i))) {
                    userAnswer[i] = guess;
                }
            }
            if(new String(userAnswer).equals(answer)) {
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
