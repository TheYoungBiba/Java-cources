package edu.hw6.task3;

public interface ExtensionFilter extends AbstractFilter {
    static AbstractFilter globMatches(String glob) {
        if (!glob.matches("^\\*\\.\\w+$")) {
            throw new IllegalArgumentException("Incorrect glob.");
        }
        return path -> path.getFileName().toString().matches(glob);
    }
}
