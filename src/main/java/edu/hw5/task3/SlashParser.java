package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class SlashParser extends DateParser {
    public SlashParser() {}

    @SuppressWarnings("magicnumber")
    private int determinateYear(String year) {
        if (year.length() < 3) {
            int temp = Integer.parseInt(year);
            return temp > LocalDate.now().getYear() - 2000 ? temp + 1900 : temp + 2000;
        }
        return Integer.parseInt(year);
    }

    @Override
    public Optional<LocalDate> parseDate(String string) {
        if (string.matches("^(\\d{1,2})/(\\d{1,2})/(\\d{1,4})$")) {
            String[] dayMonthYear = string.split("/");
            return Optional.of(LocalDate.of(determinateYear(dayMonthYear[2]),
                    Integer.parseInt(dayMonthYear[1]),
                    Integer.parseInt(dayMonthYear[0])));
        }
        return super.parseNext(string);
    }
}
