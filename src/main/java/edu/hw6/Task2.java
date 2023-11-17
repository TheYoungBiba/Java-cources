package edu.hw6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    private Task2() {}

    private static int countOfCopies(Path path) throws IOException {
        String[] fileName = path.getFileName().toString().split("\\.");
        return (int) Files.list(path.getParent())
            .filter(tempPath ->
                tempPath.getFileName().toString()
                    .matches("^" + fileName[0] + "( — копия( \\(\\d+\\))?\\.)" + fileName[1] + "$")).count();
    }

    public static void cloneFile(Path path) throws IOException {
        if (!Files.exists(path)) {
            throw new FileNotFoundException("File not found.");
        }
        String tempFileNAme;
        int count = countOfCopies(path);
        String[] fileName = path.getFileName().toString().split("\\.");
        if (count > 0) {
            tempFileNAme = fileName[0] + " — копия (" + (count + 1) + ")." + fileName[1];
        } else {
            tempFileNAme = fileName[0] + " — копия." + fileName[1];
        }
        Files.copy(path, Path.of(path.getParent().toString(), tempFileNAme));
    }
}
