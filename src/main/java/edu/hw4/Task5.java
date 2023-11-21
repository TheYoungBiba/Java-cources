package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import java.util.List;

public class Task5 {
    private Task5() {}

    public static Sex maxSex(List<Animal> listOfAnimals) {
        long countOfMale = listOfAnimals.stream().filter(animal -> animal.sex() == Sex.F).count();
        if (countOfMale > listOfAnimals.size() / 2) {
            return Sex.F;
        }
        return Sex.M;
    }
}
