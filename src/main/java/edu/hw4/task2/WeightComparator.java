package edu.hw4.task2;

import edu.hw4.animal.Animal;
import java.util.Comparator;

public class WeightComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return Integer.compare(o2.weight(), o1.weight());
    }
}
