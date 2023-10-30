package edu.hw4;

import edu.hw4.Task4;
import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    void longestNameFinderTest() {
        List<Animal> testCase = new LinkedList<>();
        Animal referent = new Animal("qwerty3333", Type.FISH, Sex.M, 0, 41, 4, false);
        Collections.addAll(testCase,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty", Type.FISH, Sex.M, 0, 41, 4, false),
            referent
        );
        assertEquals(referent, Task4.findAnimalWithLongestName(testCase));
    }
}
