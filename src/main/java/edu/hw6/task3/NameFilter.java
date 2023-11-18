package edu.hw6.task3;

public interface NameFilter extends AbstractFilter {
    static AttributeFilter regexContains(String regEx) {
        return path -> path.getFileName().toString().matches(regEx);
    }
}
