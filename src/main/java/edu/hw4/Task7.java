package edu.hw4;

import edu.hw4.animal.Animal;
import java.lang.module.FindException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Task7 {
    private Task7() {}

    public static Animal oldestAnimal(List<Animal> listOfAnimals, int K) {
        Comparator<Animal> ageComparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Integer.compare(o1.age(), o2.weight());
            }
        };
        return listOfAnimals.stream().sorted(ageComparator).limit(K).max(ageComparator).orElse(null);
    }
}
