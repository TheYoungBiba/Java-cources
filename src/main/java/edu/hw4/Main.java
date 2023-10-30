package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> listOfAnimals = new LinkedList<>();
        Collections.addAll(listOfAnimals,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty", Type.FISH, Sex.F, 0, 41, 5, false),
            new Animal("qwerty3333", Type.FISH, Sex.F, 0, 41, 4, false)
        );
//        listOfAnimals = HeightSort.toSort(listOfAnimals);
//        listOfAnimals.stream().forEach(System.out::println);
//        listOfAnimals = WeightSort.toSort(listOfAnimals, 2);
//        listOfAnimals.stream().forEach(System.out::println);
//        Task3.toMapCounter(listOfAnimals).entrySet().stream().forEach(System.out::println);
//        System.out.println(LongestNameFinder.findAnimalWithLongestName(listOfAnimals).toString());
//        System.out.println(Task5.maxSex(listOfAnimals).toString());
//        System.out.println(Task6.toMostHeavyAnimalMap(listOfAnimals).toString());
        System.out.println(Task8.findHeaviest(listOfAnimals, 50).orElse(null));
    }
}
