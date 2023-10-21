package edu.temp;

import org.jetbrains.annotations.NotNull;

public class WordGenerator implements Dictionary {
    String[] words = {
        "function",
        "variable",
        "cycle",
        "condition",
        "class",
        "object",
        "array",
        "pointer",
        "operator",
        "algorithm",
        "library",
        "compiler",
        "debugger",
        "stack",
        "queue",
        "inheritance",
        "polymorphism",
        "interface",
        "exception",
        "recursion",
        "package"
    };

    public WordGenerator() {}

    public WordGenerator(String[] words) {
        this.words = words;
    }

    @Override
    public @NotNull String randomWord() {
        return words[(int) (Math.random() * words.length)];
    }
}
