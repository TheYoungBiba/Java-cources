package edu.hw6.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface NameFilter extends AbstractFilter {
    static AttributeFilter regexContains(String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        return path -> {
            Matcher matcher = pattern.matcher(path.getFileName().toString());
            return matcher.find();
        };
    }
}
