package edu.project3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsoleParserTest {
    @ParameterizedTest
    @CsvSource("2023-08-31T14:58:06+00:00, 2023-08-31T14:58:06Z, 2023-08-31T14:58:06")
    void parseDateTimeFullTimeTest(String testCase) {
        assertEquals(ZonedDateTime.of(
            LocalDate.of(2023, 8, 31),
            LocalTime.of(14, 58, 6), ZoneId.of("Z")
        ), ConsoleParser.parseDateTime(testCase));
    }

    @Test
    void parseDateTimeDateOnlyTest() {
        assertEquals(ZonedDateTime.of(
            LocalDate.of(2023, 8, 31),
            LocalTime.MIN, ZoneId.systemDefault()), ConsoleParser.parseDateTime("2023-08-31"));
    }

    @Test
    void parseDateExceptionTest() {
        assertThrows(DateTimeException.class, () -> {
            ConsoleParser.parseDateTime("2023-08-31T14:58:6");
        });
    }
}
