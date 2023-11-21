package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static edu.hw3.Task1.atbashCipher;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @ParameterizedTest
    @CsvSource({
        "Hello world!, Svool dliow!",
        "Any fool can write code that a computer can understand., Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw.",
        "Good programmers write code that humans can understand. ― Martin Fowler, Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ, ZYXWVUTSRQPONMLKJIHGFEDCBA"
    })
    void atbashCipherStandartTest(String testCase, String referent) {
        String testResult = atbashCipher(testCase);
        assertEquals(referent, testResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "@!#$%^&*()_+=-098",
        "{}    ;!~[]"
    })
    void atbashCipherSymbolsTest(String testCase) {
        String testResult = atbashCipher(testCase);
        assertEquals(testCase, testResult);
    }
}
