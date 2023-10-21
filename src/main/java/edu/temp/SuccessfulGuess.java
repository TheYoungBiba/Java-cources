package edu.temp;

import org.jetbrains.annotations.NotNull;

public record SuccessfulGuess(char[] state, int attempts) implements GuessResult {
    @Override
    public @NotNull String message() {
        return "Successful guess! Your word is: " + new String(state) + " You spend " + attempts + " attempts.";
    }
}
