package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class HyphenParser extends DateParser {
    public HyphenParser() {}

    @Override
    public Optional<LocalDate> parseDate(String string) {
        if (string.matches("^(\\d+)-(\\d{1,2})-(\\d{1,2})$")) {
            String[] yearMonthDay = string.split("-");
            return Optional.of(LocalDate
                .of(Integer.parseInt(yearMonthDay[0]),
                    Integer.parseInt(yearMonthDay[1]),
                    Integer.parseInt(yearMonthDay[2])
                )
            );
        }
        return super.parseNext(string);
    }
}
