package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class DateParser {
    private DateParser nextParser;

    protected DateParser() {}

    protected DateParser(DateParser nextParser) {
        this.nextParser = nextParser;
    }

    protected void setNextParser(DateParser nextParser) {
        this.nextParser = nextParser;
    }

    public void chainOfNextParsers(DateParser... nextParsers) {
        DateParser head = this;
        for (DateParser next: nextParsers) {
            head.setNextParser(next);
            head = next;
        }
    }

    public static DateParser chainOf(DateParser first, DateParser... nextParsers) {
        DateParser head = first;
        for (DateParser next: nextParsers) {
            head.setNextParser(next);
            head = next;
        }
        return first;
    }

    public abstract Optional<LocalDate> parseDate(String string);

    protected Optional<LocalDate> parseNext(String string) {
        if (nextParser == null) {
            return Optional.empty();
        }
        return nextParser.parseDate(string);
    }
}
