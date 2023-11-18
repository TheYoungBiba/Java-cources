package edu.hw6;

import edu.hw6.task5.HackerNews;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task5Test {
    @Test
    void newsTest() {
        assertEquals("JDK 21 Release Notes", HackerNews.news(37570037));
        Exception e = assertThrows(RuntimeException.class, () -> {
            HackerNews.news(37570036);
        });
        assertEquals("Illegal ID, this is not a story.", e.getMessage());
    }
}
