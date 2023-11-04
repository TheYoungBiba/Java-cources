package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task14Test {
    private static Stream<Arguments> provideArguments() {
        List<Animal> testCase1 = new LinkedList<>();
        Collections.addAll(testCase1,
            new Animal("qwerty11 qwerty V", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("qwerty222 qw X", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("qwerty e", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("qwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("qwerty222 qw X", Type.DOG, Sex.F, 4, 35, 70, true),
            new Animal("qwerty222 qw X", Type.DOG, Sex.F, 4, 10, 70, true)
        );
        List<Animal> testCase2 = new LinkedList<>();
        Collections.addAll(testCase2,
            new Animal("qwerty11 qwerty V", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("qwerty222 qw X", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("qwerty e", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("qwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false)
        );
        return Stream.of(
            Arguments.of(testCase1, 20, true),
            Arguments.of(testCase2, 50, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void hereIsDogHigherK(List<Animal> testCase, int k, boolean referent) {
        assertEquals(referent, Task14.hereIsDogHigherK(testCase, k));
    }

}
