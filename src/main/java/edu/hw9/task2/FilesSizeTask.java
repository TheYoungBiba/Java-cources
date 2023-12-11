package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FilesSizeTask extends RecursiveTask<List<Path>> {
    private final Path path;

    private final long minSize;

    private final long maxSize;

    public FilesSizeTask(Path path, long minSize, long maxSize) {
        this.path = path;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    protected List<Path> compute() {
        if (Files.isRegularFile(path)) {
            return new ArrayList<>();
        }
        List<Path> listOfSizeFiles = new ArrayList<>();
        List<FilesSizeTask> tasks = new ArrayList<>();
        try (var pathStream = Files.list(path)) {
            pathStream.forEach(path -> {
                try {
                    if (Files.isRegularFile(path) && Files.size(path) >= minSize && Files.size(path) <= maxSize) {
                        listOfSizeFiles.add(path);
                    } else {
                        var task = new FilesSizeTask(path, minSize, maxSize);
                        task.fork();
                        tasks.add(task);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (var task : tasks) {
            listOfSizeFiles.addAll(task.join());
        }
        return listOfSizeFiles;
    }
}

