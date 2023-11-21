package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    private Task2() {}

    public static List<Animal> toSort(List<Animal> listOfAnimals, int k) {
        Comparator<Animal> weightComparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Integer.compare(o1.weight(), o2.weight());
            }
        };
        return listOfAnimals.stream().sorted(weightComparator.reversed()).limit(k).toList();
    }
}
