package edu;

import edu.project3.LogAnalyzer;
import edu.project3.NginxLogParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path test1 = Path.of("src/main/java/edu/project3/access.log.14");
        Path test2 = Path.of("src/main/resources/nginx_test_logs");
//        var test = Files.readAllLines(test2);
//        var logPars = new NginxLogParser();
//        for (String str: test) {
//            try {
//                logPars.parseLine(str);
//            } catch (RuntimeException e) {
//                System.out.println(e.getMessage());
//                System.out.println(str);
//            }
//        }
    }
}
