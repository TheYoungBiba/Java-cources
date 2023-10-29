package edu.hw4.task1;

import edu.hw4.animal.Animal;
import java.util.Comparator;

public class HeightComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return Integer.compare(o1.height(), o2.height());
    }
}
