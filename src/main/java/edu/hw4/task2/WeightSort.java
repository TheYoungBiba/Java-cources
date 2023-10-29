package edu.hw4.task2;

import edu.hw4.animal.Animal;
import java.util.List;

public class WeightSort {
    private WeightSort() {}

    public static List<Animal> toSort(List<Animal> listOfAnimals, int k) {
        return listOfAnimals.stream().sorted(new WeightComparator()).limit(k).toList();
    }
}
