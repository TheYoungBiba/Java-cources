package edu.project1;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult permits Win, SuccessfulGuess, Defeat, FailedGuess {
    @NotNull String message();
}
