package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task16Test {
    @Test
    void toSortByTypeSexNameTest() {
        List<Animal> testCase = new LinkedList<>();
        Collections.addAll(testCase,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Claus", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Zolotaya Ribka", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, true)
        );
        List<Animal> referent = new LinkedList<>();
        Collections.addAll(referent,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Claus", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Zolotaya Ribka", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true)
        );
        assertEquals(referent, Task16.toSortByTypeSexName(testCase));
    }
}
