package edu.hw5;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    private Task1() {}

    private record EndBegin(Instant beginning, Instant ending) {}

    private static boolean isValidInput(Collection<String> sessions) {
        final int validLength = 37;
        return sessions.stream().allMatch(s -> s.length() == validLength);
    }

    private static Instant getInstant(String endOrBegin) {
        return Instant.parse(new StringBuilder(endOrBegin)
            .replace(endOrBegin.indexOf(", "), endOrBegin.indexOf(", ") + 2, "T")
            .append(":00Z").toString());
    }

    private static EndBegin toInstantFormat(String session) {
        String beginning = session.substring(0, session.indexOf(" - "));
        String ending = session.substring(session.indexOf(" - ") + 3);
        return new EndBegin(getInstant(beginning), getInstant(ending));
    }

    private static Collection<EndBegin> toInstantList(Collection<String> sessions) {
        return sessions.stream()
            .map(s -> {
            return toInstantFormat(s);
              })
            .toList();
    }

    public static String medianTime(Collection<String> sessions) {
        if (!isValidInput(sessions)) {
            throw new IllegalArgumentException("Incorrect format of session.");
        }
        Collection<EndBegin> listOfSessions = toInstantList(sessions);
        Duration allDurations = listOfSessions.stream().reduce(Duration.ZERO, (duration, endBegin) -> {
            duration.plus(Duration.between(endBegin.beginning, endBegin.ending));
        })
    }
}
