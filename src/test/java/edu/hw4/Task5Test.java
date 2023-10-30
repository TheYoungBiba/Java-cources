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

public class Task5Test {
    private static Stream<Arguments> provideTestCasesToMaxSex() {
        List<Animal> testCaseMale = new LinkedList<>();
        Collections.addAll(testCaseMale,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty", Type.FISH, Sex.M, 0, 41, 4, false),
            new Animal("qwerty3333", Type.FISH, Sex.M, 0, 41, 4, false)
        );

        List<Animal> testCaseFemale = new LinkedList<>();
        Collections.addAll(testCaseFemale,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty", Type.FISH, Sex.F, 0, 41, 4, false),
            new Animal("qwerty3333", Type.FISH, Sex.F, 0, 41, 4, false)
        );

        List<Animal> testCaseEquals = new LinkedList<>();
        Collections.addAll(testCaseEquals,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty", Type.FISH, Sex.M, 0, 41, 4, false),
            new Animal("qwerty3333", Type.FISH, Sex.F, 0, 41, 4, false)
        );
        return Stream.of(
            Arguments.of(testCaseMale, Sex.M),
            Arguments.of(testCaseFemale, Sex.F),
            Arguments.of(testCaseEquals, Sex.M)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesToMaxSex")
    void maxSexTest(List<Animal> testCase, Sex referent) {
        assertEquals(referent, Task5.maxSex(testCase));
    }
}
