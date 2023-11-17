package edu.hw6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
    @Test
    void cloneFileExceptionTest() {
        Path testCase = Path.of("src", "main", "resources", "test.txt");
        FileNotFoundException e = assertThrows(FileNotFoundException.class, () -> {
           Task2.cloneFile(testCase);
        });
        assertEquals("File not found.", e.getMessage());
    }

    Comparator<Path> pathCmp = new Comparator<Path>() {
        @Override
        public int compare(Path o1, Path o2) {
            return o1.toString().compareTo(o2.toString());
        }
    };

    @Test
    void cloneFileStandardTest() throws IOException {
        Path testCase = Path.of("src", "main", "resources", "test.txt");
        Files.createFile(testCase);
        Task2.cloneFile(testCase);
        Task2.cloneFile(testCase);
        Task2.cloneFile(testCase);
        List<Path> referent = new LinkedList<>();
        referent.add(Path.of(testCase.getParent().toString(), "test — копия.txt"));
        referent.add(Path.of(testCase.getParent().toString(), "test — копия (2).txt"));
        referent.add(Path.of(testCase.getParent().toString(), "test — копия (3).txt"));
        referent.sort(pathCmp);
        boolean testResult = referent.equals(Files.list(testCase.getParent())
            .filter(path -> path.getFileName().toString().matches("^test( — копия( \\(\\d+\\))?)\\.txt$"))
            .sorted(pathCmp)
            .toList());
        Files.list(testCase.getParent())
            .filter(path -> path.getFileName().toString().matches("^test( — копия( \\(\\d+\\))?)?\\.txt$"))
            .forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        assertTrue(testResult);
    }
}
