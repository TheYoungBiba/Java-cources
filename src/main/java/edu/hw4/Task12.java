package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.List;

public class Task12 {
    private Task12() {}

    public static Integer countOfAnimalsWeightMoteThanHeight(List<Animal> listOfAnimals) {
        return (int) listOfAnimals.stream().filter(animal -> animal.weight() > animal.height()).count();
    }
}
