package edu.project3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileConvertorTest {
    @Test
    void test() throws IOException {
        List<Path> path = List.of(Path.of("src", "main", "resources", "nginx_test_logs"));
        var logAnalyzer = new LogAnalyzer(path, null, null);
        new FileConvertor(Format.markdown)
            .doFile(path, null, null, logAnalyzer.countOfRequests(), logAnalyzer.mediumSizeOfServerAns(),
                logAnalyzer.determinateMostRequestedResources(), logAnalyzer.determinateMostFrequentCode());
        boolean flag = Files.exists(Path.of("src", "main", "resources", "otchet.md"));
        Files.delete(Path.of("src", "main", "resources", "otchet.md"));
        assertTrue(flag);
    }
}
