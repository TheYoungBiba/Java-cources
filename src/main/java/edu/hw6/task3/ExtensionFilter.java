package edu.hw6.task3;

import java.nio.file.Files;
import java.util.regex.Pattern;

public interface ExtensionFilter extends AbstractFilter {
    static AbstractFilter globMatches(String glob) {
        if (!glob.matches("^\\*\\.\\w+$")) {
            throw new IllegalArgumentException("Incorrect glob.");
        }
        return path -> path.getFileName().toString().matches(glob);
    }
}
