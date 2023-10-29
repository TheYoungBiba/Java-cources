package edu.hw4.task1;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeightSortTest {
    @Test
    void toSortTest() {
        List<Animal> testCase = new LinkedList<>();
        Collections.addAll(testCase,
            new Animal("qwerty1", Type.CAT, Sex.M, 1, 52, 3, true),
            new Animal("qwerty2", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty3", Type.FISH, Sex.M, 0, 41, 4, false),
            new Animal("qwerty4", Type.FISH, Sex.F, 2, 41, 3, false)
        );
        List<Animal> testResult = HeightSort.toSort(testCase);
        List<Animal> referent = new LinkedList<>();
        Collections.addAll(referent,
            new Animal("qwerty2", Type.DOG, Sex.F, 3, 30, 17, true),
            new Animal("qwerty3", Type.FISH, Sex.M, 0, 41, 4, false),
            new Animal("qwerty4", Type.FISH, Sex.F, 2, 41, 3, false),
            new Animal("qwerty1", Type.CAT, Sex.M, 1, 52, 3, true)
        );
        assertEquals(referent, testResult);
    }

    private static Stream<Arguments> provideTestCasesForHeightComparatorTest() {
        Animal testCase1_1 = new Animal("qwerty1", Type.CAT, Sex.M, 1, 52, 3, true);
        Animal testCase1_2 = new Animal("qwerty2", Type.DOG, Sex.F, 3, 52, 17, true);

        Animal testCase2_1 = new Animal("qwerty1", Type.CAT, Sex.M, 1, 52, 3, true);
        Animal testCase2_2 = new Animal("qwerty2", Type.DOG, Sex.F, 3, 30, 17, true);

        Animal testCase3_1 = new Animal("qwerty1", Type.CAT, Sex.M, 1, 30, 3, true);
        Animal testCase3_2 = new Animal("qwerty2", Type.DOG, Sex.F, 3, 100, 17, true);
        return Stream.of(
            Arguments.of(testCase1_1, testCase1_2, 0),
            Arguments.of(testCase2_1, testCase2_2, 1),
            Arguments.of(testCase3_1, testCase3_2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForHeightComparatorTest")
    void heightComparatorTest(Animal testCase1, Animal testCase2, int referent) {
        assertEquals(new HeightComparator().compare(testCase1, testCase2), referent);
    }
}
