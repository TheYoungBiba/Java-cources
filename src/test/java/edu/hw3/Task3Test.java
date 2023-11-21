package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    private static Stream<Arguments> provideCollectionsForFreqDict() {
        LinkedList<String> linkedListTestCase1 = new LinkedList<>();
        linkedListTestCase1.add("a");
        linkedListTestCase1.add("bb");
        linkedListTestCase1.add("a");
        linkedListTestCase1.add("bb");
        HashMap<String, Integer> linkedListTestReferent1 = new HashMap<>();
        linkedListTestReferent1.put("a", 2);
        linkedListTestReferent1.put("bb", 2);
        ArrayList<String> arrayListTestCase = new ArrayList<>();
        arrayListTestCase.add("this");
        arrayListTestCase.add("and");
        arrayListTestCase.add("that");
        arrayListTestCase.add("and");
        HashMap<String, Integer> arrayListTestReferent = new HashMap<>();
        arrayListTestReferent.put("that", 1);
        arrayListTestReferent.put("and", 2);
        arrayListTestReferent.put("this", 1);
        Vector<String> vectorTestCase = new Vector<>();
        vectorTestCase.add("код");
        vectorTestCase.add("код");
        vectorTestCase.add("код");
        vectorTestCase.add("bug");
        HashMap<String, Integer> vectorTestReferent = new HashMap<>();
        vectorTestReferent.put("код", 3);
        vectorTestReferent.put("bug", 1);
        LinkedList<String> linkedListTestCase2 = new LinkedList<>();
        linkedListTestCase2.add("1");
        linkedListTestCase2.add("1");
        linkedListTestCase2.add("2");
        linkedListTestCase2.add("2");
        HashMap<String, Integer> linkedListTestReferent2 = new HashMap<>();
        linkedListTestReferent2.put("1", 2);
        linkedListTestReferent2.put("2", 2);
        return Stream.of(
            Arguments.of(linkedListTestCase1, linkedListTestReferent1),
            Arguments.of(arrayListTestCase, arrayListTestReferent),
            Arguments.of(vectorTestCase, vectorTestReferent),
            Arguments.of(linkedListTestCase2, linkedListTestReferent2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCollectionsForFreqDict")
    void freqDictTest(Collection<String> testCase, Map<String, Integer> referent) {
        assertTrue(Task3.freqDict(testCase).equals(referent));
    }
}
