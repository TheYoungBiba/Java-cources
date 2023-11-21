package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.lang.module.FindException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task7Test {
    private static Stream<Arguments> provideArgumentsForOldestAnimalTest() {
        List<Animal> testCase1 = new LinkedList<>();
        Collections.addAll(testCase1,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty", Type.FISH, Sex.F, 0, 41, 5, false),
            new Animal("qwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false)
        );
        Animal referent1 = new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 3, true);
        return Stream.of(
            Arguments.of(testCase1, 3, referent1),
            Arguments.of(new LinkedList<Animal>(), 3, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForOldestAnimalTest")
    void oldestAnimalTest(List<Animal> testCase, int K, Animal referent) {
        assertEquals(referent, Task7.oldestAnimal(testCase, K));
    }
}
