package edu.hw6.task3;

import java.nio.file.Files;

public interface SizeFilter extends AbstractFilter {
    static AbstractFilter largerThan(long size) {
        return path -> Files.size(path) > size;
    }

    static AbstractFilter smallerThan(long size) {
        return path -> Files.size(path) < size;
    }

    static AbstractFilter sizeEquals(long size) {
        return path -> Files.size(path) == size;
    }
}
