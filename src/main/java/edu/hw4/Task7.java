package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.Comparator;
import java.util.List;


public class Task7 {
    private Task7() {}

    public static Animal oldestAnimal(List<Animal> listOfAnimals, int k) {
        Comparator<Animal> ageComparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Integer.compare(o1.age(), o2.weight());
            }
        };
        return listOfAnimals.stream().sorted(ageComparator).limit(k).max(ageComparator).orElse(null);
    }
}
