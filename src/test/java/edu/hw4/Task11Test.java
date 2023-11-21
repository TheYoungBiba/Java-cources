package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task11Test {
    @Test
    void toListOfBitesAnd100CmTest() {
        List<Animal> testCase = new LinkedList<>();
        Collections.addAll(testCase,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 101, 3, false),
            new Animal("qwerty222", Type.DOG, Sex.F, 4, 130, 17, true),
            new Animal("qwerty", Type.FISH, Sex.F, 0, 41, 5, false),
            new Animal("qwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("animal", Type.SPIDER, Sex.F, 12, 102, 0, true)
        );
        List<Animal> referent = new LinkedList<>();
        Collections.addAll(referent,
            new Animal("qwerty222", Type.DOG, Sex.F, 4, 130, 17, true),
            new Animal("animal", Type.SPIDER, Sex.F, 12, 102, 0, true)
        );
        assertEquals(referent, Task11.toListOfBitesAnd100Cm(testCase));
    }
}
