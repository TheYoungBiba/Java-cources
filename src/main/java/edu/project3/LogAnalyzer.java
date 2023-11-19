package edu.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LogAnalyzer {
    private final List<Path> paths;

    private final ZonedDateTime from;

    private final ZonedDateTime to;

    private final int three = 3;

    public LogAnalyzer(List<Path> paths, ZonedDateTime from, ZonedDateTime to) {
        this.paths = paths;
        this.from = from;
        this.to = to;
    }

    private Stream<LogRecord> getStreamOfLogs(Path path) throws IOException {
        LogParser logParser = new NginxLogParser();
        List<String> listOfLines = Files.readAllLines(path);
        if (from == null && to == null) {
            return listOfLines.stream().map(logParser::parseLine);
        }
        if (to == null) {
            return listOfLines.stream()
                .map(logParser::parseLine)
                .filter(logRecord -> logRecord.dateOfRequest().isAfter(from));
        }
        if (from == null) {
            return listOfLines.stream()
                .map(logParser::parseLine)
                .filter(logRecord -> logRecord.dateOfRequest().isBefore(to));
        }
        return listOfLines.stream()
            .map(logParser::parseLine)
            .filter(logRecord -> logRecord.dateOfRequest().isAfter(from) && logRecord.dateOfRequest().isBefore(to));
    }

    public long countOfRequests() throws IOException {
        long count = 0;
        for (Path path: paths) {
            count += getStreamOfLogs(path).count();
        }
        return count;
    }

    public long mediumSizeOfServerAns() throws IOException {
        long count = 0;
        long size = 0;
        for (Path path: paths) {
            count += getStreamOfLogs(path).count();
            size = getStreamOfLogs(path).reduce(size, (aLong, logRecord) -> aLong + logRecord.byteSize(), Long::sum);
//            size += getStreamOfLogs(path).mapToLong(LogRecord::byteSize).sum();
        }
        return size / count;
    }


    public List<MostRequestedResource> determinateMostRequestedResources() throws IOException {
        HashMap<String, Long> resources = new HashMap<>();
        for (Path path: paths) {
            getStreamOfLogs(path)
                .forEach(logRecord -> {
                    String resource = logRecord.request().resource();
                    if (!resources.containsKey(resource)) {
                        resources.put(resource, 1L);
                    } else {
                        resources.put(resource, resources.get(resource) + 1);
                    }
                });
        }
        return resources.entrySet().stream().sorted(new Comparator<Map.Entry<String, Long>>() {
                @Override
                public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                    return Long.compare(o1.getValue(), o2.getValue());
                }
            }.reversed())
            .limit(three)
            .map(stringLongEntry -> new MostRequestedResource(stringLongEntry.getKey(), stringLongEntry.getValue()))
            .toList();
    }

    public List<MostFrequentCode> determinateMostFrequentCode() throws IOException {
        HashMap<Integer, Long> codes = new HashMap<>();
        for (Path path: paths) {
            getStreamOfLogs(path)
                .forEach(logRecord -> {
                    int code = logRecord.httpStatusCode();
                    if (!codes.containsKey(code)) {
                        codes.put(code, 1L);
                    } else {
                        codes.put(code, codes.get(code) + 1);
                    }
                });
        }
        return codes.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Long>>() {
                @Override
                public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
                    return Long.compare(o1.getValue(), o2.getValue());
                }
            }.reversed())
            .limit(three)
            .map(integerLongEntry -> new MostFrequentCode(toEnumVal(integerLongEntry.getKey()),
                integerLongEntry.getValue()))
            .toList();

    }

    private LogRecord.HttpStatusCode toEnumVal(int code) {
        for (LogRecord.HttpStatusCode enumCode: LogRecord.HttpStatusCode.values()) {
            if (enumCode.getCode() == code) {
                return enumCode;
            }
        }
        throw new RuntimeException("Unknown code");
    }

    public record MostRequestedResource(String name, long count) {}


    public record MostFrequentCode(LogRecord.HttpStatusCode statusCode, long count) {}
}
