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

public class Task17Test {
    private static Stream<Arguments> provideArguments() {
        List<Animal> testCase1 = new LinkedList<>();
        Collections.addAll(testCase1,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Claus", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Zolotaya Ribka", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, false)
        );
        List<Animal> testCase2 = new LinkedList<>();
        Collections.addAll(testCase2,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Claus", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Zolotaya Ribka", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, true)
        );
        List<Animal> testCase3 = new LinkedList<>();
        Collections.addAll(testCase3,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Claus", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Zolotaya Ribka", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Pter", Type.SPIDER, Sex.M, 28, 175, 75, true),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true)
        );
        List<Animal> testCase4 = new LinkedList<>();
        Collections.addAll(testCase4,
            new Animal("Murzick", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Karma", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("White", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("Claus", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("Zolotaya Ribka", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("aqwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false),
            new Animal("Baton", Type.CAT, Sex.F, 1, 101, 3, true),
            new Animal("Druzchock", Type.DOG, Sex.M, 4, 30, 70, true),
            new Animal("Cerber", Type.DOG, Sex.F, 4, 30, 70, true)
        );
        return Stream.of(
            Arguments.of(testCase1, true),
            Arguments.of(testCase2, false),
            Arguments.of(testCase3, false),
            Arguments.of(testCase4, false)
        );
    }
    @ParameterizedTest
    @MethodSource("provideArguments")
    void areSpidersBitesMore(List<Animal> testCase, boolean referent) {
        assertEquals(referent, Task17.areSpidersBitesMore(testCase));
    }
}
