package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import edu.hw4.task1.HeightSort;
import edu.hw4.task2.WeightSort;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> listOfAnimals = new LinkedList<>();
        Collections.addAll(listOfAnimals,
            new Animal("qwerty1", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty2", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty3", Type.FISH, Sex.M, 0, 41, 4, false));
//        listOfAnimals = HeightSort.toSort(listOfAnimals);
//        listOfAnimals.stream().forEach(System.out::println);
        listOfAnimals = WeightSort.toSort(listOfAnimals, 2);
        listOfAnimals.stream().forEach(System.out::println);
    }
}
