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

public class Task8Test {
    private static Stream<Arguments> provideTestCasesForFindHeaviest() {
        List<Animal> testCaseList = new LinkedList<>();
        Collections.addAll(testCaseList,
            new Animal("qwerty11", Type.CAT, Sex.M, 1, 52, 20, true),
            new Animal("qwerty222", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty", Type.FISH, Sex.F, 0, 41, 5, false),
            new Animal("qwerty3333", Type.FISH, Sex.F, 0, 41, 4, false)
        );
        return Stream.of(
            Arguments.of(testCaseList, 50, new Animal("qwerty222", Type.DOG, Sex.F, 3, 30,
                17, true)),
            Arguments.of(testCaseList, 20, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForFindHeaviest")
    void findHeaviest(List<Animal> testCaseList, int testCaseK, Animal referent) {
        assertEquals(Task8.findHeaviest(testCaseList, testCaseK).orElse(null), referent);
    }
}
