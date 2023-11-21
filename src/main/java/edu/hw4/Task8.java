package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task8 {
    private Task8() {}

    public static Optional<Animal> findHeaviest(List<Animal> listOfAnimals, int k) {
        Comparator<Animal> weightCmp = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Integer.compare(o1.weight(), o2.weight());
            }
        };
        return listOfAnimals.stream().filter(animal -> animal.height() < k).max(weightCmp);
    }
}
