package edu.hw6;

//добавить возможность работы с файлами типа .file и file в задаине 2 и добавить в задание memoryMappedFile

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
//        Task4.outputStreamsComposer();
        System.out.println(Files.readString(Path.of("src", "main", "resources", "task4Output.txt"), StandardCharsets.UTF_8));
    }
}
