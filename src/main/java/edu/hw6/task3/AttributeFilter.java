package edu.hw6.task3;

import java.nio.file.Files;

public interface AttributeFilter extends AbstractFilter {
    AbstractFilter regularFile = Files::isRegularFile;

    AbstractFilter readableFile = Files::isReadable;

    AbstractFilter writableFile = Files::isWritable;
}
