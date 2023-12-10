package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @ParameterizedTest
    @CsvSource({
        "qw erty, false",
        "~qw erty, false",
        "qwerty, false",
        "~qwerty, true",
        "qwerty~, true",
        "qwe~rty, true",
        "~qwe~rty, true",
        "~qwe~rty~, true",
        "~~qwerty, true",
        "qwe~~rty, true",
        "qwerty~~, true",
        "!qwerty, true",
        "qwerty!, true",
        "qwe!rty, true",
        "!qwe!rty, true",
        "!qwe!rty!, true",
        "!!qwerty, true",
        "qwe!!rty, true",
        "qwerty!!, true",
        "@qwerty, true",
        "qwerty@, true",
        "qwe@rty, true",
        "@qwe@rty, true",
        "@qwe@rty@, true",
        "@@qwerty, true",
        "qwe@@rty, true",
        "qwerty@@, true",
        "#qwerty, true",
        "qwerty#, true",
        "qwe#rty, true",
        "#qwe#rty, true",
        "#qwe#rty#, true",
        "##qwerty, true",
        "qwe##rty, true",
        "qwerty##, true",
        "$qwerty, true",
        "qwerty$, true",
        "qwe$rty, true",
        "$qwe$rty, true",
        "$qwe$rty$, true",
        "$$qwerty, true",
        "qwe$$rty, true",
        "qwerty$$, true",
        "%qwerty, true",
        "qwerty%, true",
        "qwe%rty, true",
        "%qwe%rty, true",
        "%qwe%rty%, true",
        "%%qwerty, true",
        "qwe%%rty, true",
        "qwerty%%, true",
        "^qwerty, true",
        "qwerty^, true",
        "qwe^rty, true",
        "^qwe^rty, true",
        "^qwe^rty^, true",
        "^^qwerty, true",
        "qwe^^rty, true",
        "qwerty^^, true",
        "&qwerty, true",
        "qwerty&, true",
        "qwe&rty, true",
        "&qwe&rty, true",
        "&qwe&rty&, true",
        "&&qwerty, true",
        "qwe&&rty, true",
        "qwerty&&, true",
        "*qwerty, true",
        "qwerty*, true",
        "qwe*rty, true",
        "*qwe*rty, true",
        "*qwe*rty*, true",
        "**qwerty, true",
        "qwe**rty, true",
        "qwerty**, true",
        "|qwerty, true",
        "qwerty|, true",
        "qwe|rty, true",
        "|qwe|rty, true",
        "|qwe|rty|, true",
        "||qwerty, true",
        "qwe||rty, true",
        "qwerty||, true",
        "|&qwerty, true",
        "qwe$|rty, true",
        "qwerty!%|, true"
    })
    void isValidPasswordTest(String testCase, boolean referent) {
        assertEquals(referent, Task4.isValidPassword(testCase));
    }
}