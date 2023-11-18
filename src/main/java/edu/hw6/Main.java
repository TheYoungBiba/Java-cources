package edu.hw6;

import edu.hw6.task3.MagicNumberFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.task3.SizeFilter.smallerThan;

public class Main {
    public static void main(String[] args) throws IOException {
        DirectoryStream.Filter<Path> filter = MagicNumberFilter.magicNumber(0x89, 'P', 'N', 'G').and(smallerThan(400_000));
        Files.newDirectoryStream(Path.of("src", "main", "resources"), filter).forEach(System.out::println);
//        System.out.println(Files.isWritable(Path.of("src", "main", "resources", "image (4).jpg")));
    }
}

