package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task18Test {
    @Test
    void heaviestFishTest() {
        List<Animal> testCase11 = new LinkedList<>();
        Collections.addAll(testCase11,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Claus1", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Zolotaya Ribka2", Type.FISH, Sex.F, 0, 41, 51, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
        List<Animal> testCase12 = new LinkedList<>();
        Collections.addAll(testCase12,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Claus3", Type.FISH, Sex.F, 0, 41, 30, false),
            new Animal("Claus4", Type.FISH, Sex.F, 0, 41, 70, false),
            new Animal("Zolotaya Ribka5", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
        List<Animal> testCase13 = new LinkedList<>();
        Collections.addAll(testCase13,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
        List<Animal> testCase14 = new LinkedList<>();
        Collections.addAll(testCase14,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Claus", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Zolotaya Ribka", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, true)
        );
        assertEquals(new Animal("Claus4", Type.FISH, Sex.F, 0, 41, 70, false),
            Task18.heaviestFish(testCase11, testCase12, testCase13, testCase14));
    }

    @Test
    void heaviestFishTestWithNull() {
        List<Animal> testCase21 = new LinkedList<>();
        Collections.addAll(testCase21,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
        List<Animal> testCase22 = new LinkedList<>();
        Collections.addAll(testCase22,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
        assertNull(Task18.heaviestFish(testCase21, testCase22));
    }
}
