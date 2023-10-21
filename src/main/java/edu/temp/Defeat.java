package edu.temp;

import org.jetbrains.annotations.NotNull;

public record Defeat(String answer, int attempts) implements GuessResult {
    @Override
    public @NotNull String message() {
        return "You loose! Your word was: " + answer + " You spend " + attempts + " attempts";
    }
}
