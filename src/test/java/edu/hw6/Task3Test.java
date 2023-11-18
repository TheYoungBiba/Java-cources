package edu.hw6;

import edu.hw6.task3.AttributeFilter;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import static edu.hw6.task3.AttributeFilter.readableFile;
import static edu.hw6.task3.AttributeFilter.writableFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {
    Path pathToDir = Path.of("src", "main", "resources");
    Path pathToImage =  Path.of("src", "main", "resources", "image.png");

    @Test
    void attributeFilterTest() throws IOException {
        List<Path> temp = new LinkedList<>();
        Files.newDirectoryStream(pathToDir, writableFile).forEach(temp::add);
        assertEquals(pathToImage, );
    }
}
