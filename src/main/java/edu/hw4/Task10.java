package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.List;

public class Task10 {
    private Task10() {}

    public static List<Animal> toListWithDifferentValsOfAgeAndPaws(List<Animal> listOfAnimals) {
        return listOfAnimals.stream().filter(animal -> animal.paws() != animal.age()).toList();
    }
}
