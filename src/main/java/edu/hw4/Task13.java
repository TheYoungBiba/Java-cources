package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.List;

public class Task13 {
    private Task13() {}

    private static int wordCounter(String str) {
        return str.length() - str.replace(" ", "").length() + 1;
    }

    public static List<Animal> toLostOfTwoWordsInName(List<Animal> listOfAnimals) {
        return listOfAnimals.stream().filter(animal -> wordCounter(animal.name()) > 2).toList();
    }
}
