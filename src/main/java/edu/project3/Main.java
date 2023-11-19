package edu.project3;

import java.io.IOException;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private Main() {}

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        List<Path> listOfPath = PathFinder.config(args);
        ZonedDateTime from = null;
        ZonedDateTime to = null;
        Format format = null;
        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case ("--from"): {
                    from = ConsoleParser.parseDateTime(args[i + 1]);
                    break;
                }
                case ("--to"): {
                    to = ConsoleParser.parseDateTime(args[i + 1]);
                    break;
                }
                case ("--format"): {
                    format = Format.valueOf(args[i + 1]);
                    break;
                }
                default: throw new IllegalArgumentException();
            }
        }
        LogAnalyzer analyzer = new LogAnalyzer(listOfPath, from, to);
        LOGGER.info(Renderer.mainInformationRender(listOfPath, from, to, analyzer.countOfRequests(),
            analyzer.mediumSizeOfServerAns()));
        LOGGER.info(Renderer.resourcesRender(analyzer.determinateMostRequestedResources()));
        LOGGER.info(Renderer.codeRenderer(analyzer.determinateMostFrequentCode()));
        if (format != null) {
            new FileConvertor(format).doFile(listOfPath,
                from,
                to,
                analyzer.countOfRequests(),
                analyzer.mediumSizeOfServerAns(),
                analyzer.determinateMostRequestedResources(),
                analyzer.determinateMostFrequentCode()
            );
        }
    }
}
