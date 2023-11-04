package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.List;

public class Task11 {
    private Task11() {}

    public static List<Animal> toListOfBitesAnd100Cm(List<Animal> listOfAnimals) {
        return listOfAnimals.stream().filter(animal -> (animal.bites() && animal.height() > 100)).toList();
    }
}
