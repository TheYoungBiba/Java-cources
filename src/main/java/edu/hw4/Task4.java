package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.Comparator;
import java.util.List;

public class Task4 {
    private Task4() {}

    public static Animal findAnimalWithLongestName(List<Animal> listOfAnimals) {
        Comparator<Animal> nameLengthCmp = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Integer.compare(o1.name().length(), o2.name().length());
            }
        };
        return listOfAnimals.stream().max(nameLengthCmp).orElse(null);
    }
}
