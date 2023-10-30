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

public class Task6Test {
    @Test
    void toMostHeavyAnimalMapTest() {
        List<Animal> testCase = new LinkedList<>();
        Collections.addAll(testCase,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty11", Type.CAT, Sex.F, 1, 52, 7, true),
            new Animal("qwerty", Type.FISH, Sex.F, 0, 41, 5, false),
            new Animal("qwerty3333", Type.FISH, Sex.F, 0, 41, 4, false)
        );
        Map<Type, Animal> testResult = Task6.toMostHeavyAnimalMap(testCase);
        Map<Type, Animal> referent = new HashMap<>();
        referent.put(Type.FISH, new Animal("qwerty", Type.FISH, Sex.F, 0, 41, 5, false));
        referent.put(Type.BIRD, null);
        referent.put(Type.SPIDER, null);
        referent.put(Type.CAT, new Animal("qwerty11", Type.CAT, Sex.F, 1, 52, 7, true));
        referent.put(Type.DOG, new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true));
        assertEquals(referent, testResult);
    }
}
