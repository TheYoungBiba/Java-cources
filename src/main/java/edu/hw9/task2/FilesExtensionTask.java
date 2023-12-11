package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FilesExtensionTask extends RecursiveTask<List<Path>> {
    private final Path path;

    private final String extension;

    public FilesExtensionTask(Path path, String extension) {
        this.path = path;
        if (!isValid(extension)) {
            throw new IllegalArgumentException();
        }
        this.extension = extension;
    }

    @Override
    protected List<Path> compute() {
        if (Files.isRegularFile(path)) {
            return new ArrayList<>();
        }
        List<Path> listOfSizeFiles = new ArrayList<>();
        List<FilesExtensionTask> tasks = new ArrayList<>();
        try (var pathStream = Files.list(path)) {
            pathStream.forEach(path -> {
                if (Files.isRegularFile(path) && path.getFileName().toString().endsWith(extension)) {
                    listOfSizeFiles.add(path);
                } else {
                    var task = new FilesExtensionTask(path, extension);
                    task.fork();
                    tasks.add(task);
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

    private boolean isValid(String extension) {
        return extension.matches("^\\.\\S+$");
    }
}


