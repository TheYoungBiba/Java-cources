package edu.temp;

public class Main {
    public static void main(String[] args) {
        Hangman hangman = new Hangman(new WordGenerator().randomWord(), 6);
        hangman.run();
    }
}
