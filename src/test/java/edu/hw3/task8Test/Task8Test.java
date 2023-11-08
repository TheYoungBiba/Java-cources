package edu.hw3.task8Test;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @Test
    void backwardIteratorTest() {
        List<Integer> testCase = List.of(1, 2, 3);
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(testCase);
        List<Integer> tempTestCase = new LinkedList<>();
        List<Integer> referent = List.of(3, 2, 1);
        while (backwardIterator.hasNext()) {
            tempTestCase.add(backwardIterator.next());
        }
        assertThat(tempTestCase.equals(referent)).isTrue();
    }
}
