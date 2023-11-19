package edu.project3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class LogAnalyzer {
    private final Path[] paths;

    public LogAnalyzer(Path... paths) {
        this.paths = paths;
    }

    public Stream<LogRecord> getStreamOfLogs(Path path) throws IOException {
        if (!Files.exists(path)) {
            throw new FileNotFoundException();
        }
        LogParser logParser = new NginxLogParser();
        List<String> listOfLines = Files.readAllLines(path);
        return listOfLines.stream().map(logParser::parseLine);
    }

    public long countOfRequests() throws IOException {
        long count = 0;
        for (Path path: paths) {
            count += getStreamOfLogs(path).count();
        }
        return count;
    }

    public String determinateMostRequestedResources() {
        HashMap<String, Long> resources = new HashMap<>();
        for (Path path: paths) {

        }
    }

}
