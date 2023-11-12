package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class Parser {
    private Parser() {}

    public static Optional<LocalDate> parseDate(String string) {
        DateParser dateParser = DateParser.chainOf(new HyphenParser(), new SlashParser(),
            new WordParser(), new DaysParser());
        return dateParser.parseDate(string);
    }
}
