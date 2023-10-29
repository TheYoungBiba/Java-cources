package edu.hw4.task1;

import edu.hw4.animal.Animal;
import java.util.List;

public class HeightSort {
    private HeightSort() {}

    static public List<Animal> toSort(List<Animal> listOfAnimals) {
        return listOfAnimals.stream().sorted(new HeightComparator()).toList();
    }
}
