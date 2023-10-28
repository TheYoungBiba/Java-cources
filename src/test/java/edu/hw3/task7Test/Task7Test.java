package edu.hw3.task7Test;

import edu.hw3.task7.NullComparator;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    TreeMap<String, String> tree = new TreeMap<>(new NullComparator());

    @Test
    void nullComparatorTest() {
        tree.put(null, "test");
        tree.put("test2", "test2");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
