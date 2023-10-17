package edu.project1;

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
    public String randomWord() {
        return words[(int) (Math.random() * words.length)];
    }
}
