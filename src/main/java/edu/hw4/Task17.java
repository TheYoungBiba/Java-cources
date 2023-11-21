package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Type;
import java.util.List;

public class Task17 {
    private Task17() {}

    private static double coefficientOfBiteness(Type type, List<Animal> listOfAnimals) {
        double countOfAnimals = listOfAnimals.stream()
            .filter(animal -> animal.type().equals(type))
            .count();
        if (countOfAnimals == 0) {
            return -1;
        }
        double countBitingAnimals = listOfAnimals.stream()
            .filter(animal -> animal.type().equals(type) && animal.bites())
            .count();
        return countBitingAnimals / countOfAnimals;
    }

    public static Boolean areSpidersBitesMore(List<Animal> listOfAnimals) {
        double spidersBites = coefficientOfBiteness(Type.SPIDER, listOfAnimals);
        double dogBites = coefficientOfBiteness(Type.DOG, listOfAnimals);
        if (spidersBites == -1 || dogBites == -1) {
            return false;
        }
        return spidersBites > dogBites;
    }
}
