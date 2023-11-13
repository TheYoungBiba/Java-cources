package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @ParameterizedTest
    @CsvSource({
        "abc, achfdbaabgabcaabg, true",
        "abc, achabcfdbaabgabcaabg, true",
        "abc, abc, true",
        "abc, a, false",
        "abc, ab, false",
        "abc, abd, false",
        "abc, achfdbaabgabaabg, false"
    })
    void subsequenceFinderTest(String testSubsequence, String testString, boolean referent) {
        assertEquals(referent, Task6.subsequenceFinder(testSubsequence, testString));
    }
}
