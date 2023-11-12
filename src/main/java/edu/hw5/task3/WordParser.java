package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class WordParser extends DateParser {
    public WordParser() {}

    @Override
    public Optional<LocalDate> parseDate(String string) {
        return switch (string) {
            case ("tomorrow") -> Optional.of(LocalDate.now().plusDays(1));
            case ("today") -> Optional.of(LocalDate.now());
            case ("yesterday") -> Optional.of(LocalDate.now().minusDays(1));
            default -> super.parseNext(string);
        };
    }
}
