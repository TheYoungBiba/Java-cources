package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task15Test {
    @Test
    void toFindSumWeightOfEachAnimalType() {
        List<Animal> testCase = new LinkedList<>();
        Collections.addAll(testCase,
            new Animal("qwerty11 qwerty V", Type.CAT, Sex.M, 10, 101, 3, true),
            new Animal("qwerty222 qw X", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("qwerty e", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("qwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("qwerty222 qw X", Type.DOG, Sex.F, 2, 30, 10, true),
            new Animal("qwerty222 qw X", Type.SPIDER, Sex.M, 2, 10, 1, true)
        );
        Map<Type, Integer> referent = new HashMap<>();
        referent.put(Type.BIRD, 0);
        referent.put(Type.FISH, 0);
        referent.put(Type.CAT, 0);
        referent.put(Type.DOG, 80);
        referent.put(Type.SPIDER, 1);
        assertEquals(referent, Task15.toFindSumWeightOfEachAnimalType(testCase, 2, 5));
    }
}
