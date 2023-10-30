package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    private Task1() {}

    static public List<Animal> toSort(List<Animal> listOfAnimals) {
        Comparator<Animal> heighComparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Integer.compare(o1.height(), o2.height());
            }
        };
        return listOfAnimals.stream().sorted(heighComparator).toList();
    }
}
