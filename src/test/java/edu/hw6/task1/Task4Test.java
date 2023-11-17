package edu.hw6.task1;

import edu.hw6.Task4;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    private static Path referent = Path.of("src", "main", "resources", "task4Output.txt");

    @Test
    void outputStreamsComposerTest() throws IOException {
        Task4.outputStreamsComposer();
        assertTrue(Files.exists(referent));
        assertEquals("Programming is learned by writing programs. ― Brian Kernighan",
            Files.readString(referent, StandardCharsets.UTF_8));
    }

    @AfterAll
    public static void deleteTestFile() throws IOException {
        Files.delete(referent);
    }
}
