package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task2 {
    private Task2() {}

    @SuppressWarnings("magicnumber")
    public static String fridayThe13th(int year) {
        List<LocalDate> listOfFridays13th = new LinkedList<>();
        for (Month month: Month.values()) {
            LocalDate temp13thDate = LocalDate.of(year, month, 13);
            if (temp13thDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                listOfFridays13th.add(temp13thDate);
            }
        }
        return listOfFridays13th.toString();
    }

    @SuppressWarnings("magicnumber")
    public static LocalDate findFirstFridayThe13th(LocalDate startDate) {
        if (startDate.getDayOfWeek().equals(DayOfWeek.FRIDAY) && startDate.getDayOfMonth() == 13) {
            return startDate;
        }

        TemporalAdjuster fridayThe13thAdjuster = new TemporalAdjuster() {
            private LocalDate nextFridayThe13th(LocalDate startDate) {
                return Arrays.stream(Month.values())
                    .map(month -> LocalDate.of(startDate.getYear(), month, 13))
                    .filter(localDate ->
                        localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY) && startDate.isBefore(localDate))
                    .findFirst()
                    .orElseGet(() -> nextFridayThe13th(startDate.with(TemporalAdjusters.firstDayOfNextYear())));
            }

            @Override
            public Temporal adjustInto(Temporal temporal) {
                return nextFridayThe13th((LocalDate) temporal);
            }
        };

        return startDate.with(fridayThe13thAdjuster);
    }
}
