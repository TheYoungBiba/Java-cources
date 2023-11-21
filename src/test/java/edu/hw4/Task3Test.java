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

public class Task3Test {
    @Test
    void counterTest() {
        List<Animal> testCase = new LinkedList<>();
        Collections.addAll(testCase,
            new Animal("qwerty1", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty2", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty3", Type.FISH, Sex.M, 0, 41, 4, false),
            new Animal("qwerty3", Type.FISH, Sex.M, 0, 41, 4, false)
        );
        Map<Type, Integer> testResult = Task3.toMapCounter(testCase);
        Map<Type, Integer> referent = new HashMap<>();
        referent.put(Type.FISH, 2);
        referent.put(Type.BIRD, 0);
        referent.put(Type.SPIDER, 0);
        referent.put(Type.CAT, 1);
        referent.put(Type.DOG, 1);
        assertEquals(referent, testResult);
    }
}
