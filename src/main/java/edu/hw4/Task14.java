package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Type;
import java.util.List;

public class Task14 {
    private Task14() {}

    public static Boolean hereIsDogHigherK(List<Animal> listOfAnimals, int k) {
        return listOfAnimals.stream().anyMatch(animal -> (animal.height() > k && animal.type() == Type.DOG));
    }
}
