package edu.hw6.task3;

import java.nio.file.Files;

public interface AttributeFilter extends AbstractFilter {
    static AbstractFilter regularFile() {
        return Files::isRegularFile;
    }

    static AbstractFilter readableFile() {
        return Files::isReadable;
    }

    static AbstractFilter writableFile() {
        return Files::isWritable;
    }
}
