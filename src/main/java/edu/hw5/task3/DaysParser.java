package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class DaysParser extends DateParser {
    public DaysParser() {}

    @Override
    public Optional<LocalDate> parseDate(String string) {
        if (string.matches("^(\\d+) (day|days) (ago)$")) {
            return Optional.of(LocalDate.now().minusDays(Integer.parseInt(string.substring(0, string.indexOf(" ")))));
        }
        return super.parseNext(string);
    }
}
