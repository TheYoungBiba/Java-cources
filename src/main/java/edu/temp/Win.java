package edu.temp;

import org.jetbrains.annotations.NotNull;

public record Win(char[] state, int attempts) implements GuessResult {
    @Override
    public @NotNull String message() {
        return "You win! Your word was: " + new String(state) + " You spend " + attempts + " attempts.";
    }
}
