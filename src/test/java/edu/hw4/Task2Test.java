package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    void toSortTest() {
        List<Animal> testCase = new LinkedList<>();
        Collections.addAll(testCase,
            new Animal("qwerty1", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty2", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty3", Type.FISH, Sex.M, 0, 41, 4, false),
            new Animal("qwerty4", Type.FISH, Sex.F, 2, 41, 3, false)
        );
        List<Animal> testResult = Task2.toSort(testCase, 2);
        List<Animal> referent = new LinkedList<>();
        Collections.addAll(referent,
            new Animal("qwerty2", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty3", Type.FISH, Sex.M, 0, 41, 4, false)
        );
        assertEquals(referent, testResult);
    }
}
