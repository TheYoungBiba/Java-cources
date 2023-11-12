package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {
    @ParameterizedTest
    @CsvSource({
        "ФФ123ФФ123, false",
        "123ВГ777, false",
        "А23ВЕ777, false",
        "А3ВЕ777, false",
        "АВЕ777, false",
        "А3333ВЕ777, false",
        "Ф123Ф123, false",
        "Ф123123, false",
        "Ф123ФФФ777, false",
        "А123ВГ, false",
        "А123ВГ7, false",
        "А123ВГ77, false",
        "А123ВГ7777, false",
        "123АВЕ777, false",
        "А123ВГ77, false",
        "А123ВЕ7777, false",
        "А123ВЕ777, true",
        "О777ОО177, true"
    })
    void isValidLicensePlateTest(String testCase, boolean referent) {
        assertEquals(referent, Task5.isValidLicensePlate(testCase));
    }
}
