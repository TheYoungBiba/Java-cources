package edu.project3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConsoleParser {
    private ConsoleParser() {}

    @SuppressWarnings("magcnumber")
    public static ZonedDateTime parseDateTime(String time) {
        if (time.split("T").length == 1) {
            return ZonedDateTime.of(LocalDate.parse(time), LocalTime.MIN, ZoneId.systemDefault());
        } else {
            if (time.endsWith("Z")) {
                return ZonedDateTime.of(
                    LocalDateTime.parse(time.substring(0, time.length() - 1)),
                    ZoneId.of("Z"));
            } else {
                final int FIVE = 5;
                return ZonedDateTime.of(
                    LocalDateTime.parse(time.substring(0, time.length() - FIVE)),
                    ZoneId.of(time.substring(time.length() - FIVE, time.length())));
            }
        }
    }
}
