package edu.project3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.List;

public class FileConvertor {
    private Format format;

    public FileConvertor(Format format) {
        this.format = format;
    }


    @SuppressWarnings("multiplestringliterals")
    public void doFile(List<Path> listOfPath, ZonedDateTime from, ZonedDateTime to,
        long countOfRequests, long mediumSizeOfServerAns,
        List<LogAnalyzer.MostRequestedResource> determinateMostRequestedResources,
        List<LogAnalyzer.MostFrequentCode> determinateMostFrequentCode) throws IOException {
        if (format.equals(Format.markdown)) {
            Files.writeString(Path.of("src", "main", "resources", "otchet.md"),
                Renderer.mainInformationRender(listOfPath, from, to, countOfRequests, mediumSizeOfServerAns) + "\n"
                    + Renderer.resourcesRender(determinateMostRequestedResources) + "\n"
                    + Renderer.codeRenderer(determinateMostFrequentCode));
        } else {
            Files.writeString(Path.of("src", "main", "resources", "otchet.adoc"),
                "```" + Renderer.mainInformationRender(listOfPath, from, to, countOfRequests,
                    mediumSizeOfServerAns) + "\n"
                    + Renderer.resourcesRender(determinateMostRequestedResources) + "\n"
                    + Renderer.codeRenderer(determinateMostFrequentCode) + "```");
        }
    }
}
