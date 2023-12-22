package edu.hw10;

import edu.hw10.task2.CacheProxy;
import edu.hw10.task2.fibonacci.FibCalculator;
import edu.hw10.task2.fibonacci.Fibonacci;
import edu.hw10.task2.summa.SumCalculator;
import edu.hw10.task2.summa.Summa;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {
    private final Path cacheDir = Path.of("src", "main", "java", "edu", "hw10", "task2", "cache");

    @Test
    void SumPersistTrueTest() throws IOException {
        long referent;
        try (Stream<Path> pathStream = Files.list(cacheDir)) {
            referent = pathStream.count() + 1;
        }
        SumCalculator c = new Summa();
        SumCalculator testCase = CacheProxy.create(c, SumCalculator.class);
        testCase.sum(10, 11);
        long testResult;
        try (Stream<Path> pathStream = Files.list(cacheDir)) {
            testResult = pathStream.count();
        }
        Files.delete(Path.of(cacheDir + "/sum([10, 11]).txt"));
        assertEquals(referent, testResult);
    }

    @Test
    void SumPersistTest() throws IOException {
        Path extistedPath = Path.of(cacheDir + "/sum([7, 9]).txt");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(extistedPath.toFile()))) {
            out.writeObject(16);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long referent;
        try (Stream<Path> pathStream = Files.list(cacheDir)) {
            referent = pathStream.count();
        }
        SumCalculator c = new Summa();
        SumCalculator testCase = CacheProxy.create(c, SumCalculator.class);
        testCase.sum(7, 9);
        long testResult;
        try (Stream<Path> pathStream = Files.list(cacheDir)) {
            testResult = pathStream.count();
        }
        Files.delete(extistedPath);
        assertEquals(referent, testResult);
    }

    @Test
    void FibPersistFalseTest() throws IOException {
        long referent;
        try (Stream<Path> pathStream = Files.list(cacheDir)) {
            referent = pathStream.count();
        }
        FibCalculator c = new Fibonacci();
        FibCalculator testCase = CacheProxy.create(c, FibCalculator.class);
        long test = testCase.fib(10);
        long testResult;
        try (Stream<Path> pathStream = Files.list(cacheDir)) {
            testResult = pathStream.count();
        }
        assertEquals(referent, testResult);
    }
}
