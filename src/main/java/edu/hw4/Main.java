package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> testCase1 = new LinkedList<>();
        Collections.addAll(testCase1,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
//            new Animal("Claus1", Type.FISH, Sex.F, 0, 41, 50, false),
//            new Animal("Zolotaya Ribka2", Type.FISH, Sex.F, 0, 41, 51, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
        List<Animal> testCase2 = new LinkedList<>();
        Collections.addAll(testCase2,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
//            new Animal("Claus3", Type.FISH, Sex.F, 0, 41, 30, false),
//            new Animal("Claus4", Type.FISH, Sex.F, 0, 41, 70, false),
//            new Animal("Zolotaya Ribka5", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
        List<Animal> testCase3 = new LinkedList<>();
        Collections.addAll(testCase3,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
//        testCase.stream().forEach(System.out::println);
//        testCase.stream().forEach(System.out::println);
//        Task3.toMapCounter(testCase).entrySet().stream().forEach(System.out::println);
//        System.out.println(Task5.maxSex(testCase).toString());
//        System.out.println(Task6.toMostHeavyAnimalMap(testCase).toString());
//        System.out.println(Task8.findHeaviest(testCase, 50).orElse(null));
//        System.out.println(Task9.countOfPaws(testCase));
//        System.out.println(Task7.oldestAnimal(testCase, 3));
//        Task10.toListWithDifferentValsOfAgeAndPaws(testCase).stream().forEach(System.out::println);
//        Task11.toListOfBitesAnd100Cm(testCase).forEach(System.out::println);
//        var test = Task3.toMapCounter(testCase);
//        for (Type key: Type.values()) {
//            System.out.println(test.get(key));
//        }
//        System.out.println(Task12.countOfAnimalsWeightMoteThanHeight(testCase));
//        Task13.toLostOfTwoWordsInName(testCase).forEach(System.out::println);
//        System.out.println(Task14.hereIsDogHigherK(testCase, 31));
//        System.out.println(Task15.toFindSumWeightOfEachAnimalType(testCase, 0, 5).toString());
//        Task16.toSortByTypeSexName(testCase).stream().forEach(System.out::println);
//        System.out.println(Task17.areSpidersBitesMore(testCase));
//        testCase.stream().map(animal -> animal.name()).toList().stream().forEach(System.out::println);
        System.out.println(Task18.heaviestFish(testCase1, testCase2, testCase3));
    }
}
