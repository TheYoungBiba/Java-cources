package edu.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathFinderTest {

    @Test
    void configTest() throws IOException {
        String[] testCase = {
            "--path",
            "src/main/resources/nginx_test_logs",
            "src/main/resources/nginx_test_logs",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            "--from"
        };
        List<Path> referent = List.of(Path.of("src", "main", "resources", "nginx_test_logs"),
            Path.of("src", "main", "resources", "nginx_test_logs"),
            Path.of("src", "main", "resources", "nginx_logs")
        );
        assertEquals(referent, PathFinder.config(testCase));
    }

    @AfterAll
    public static void deleteRemoteFile() throws IOException {
        Path path = Path.of("src", "main", "resources", "nginx_logs");
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }
}
