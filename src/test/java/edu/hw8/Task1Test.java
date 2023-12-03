package edu.hw8;

import edu.hw8.task1.server.InsultDictionary;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @ParameterizedTest
    @CsvSource(value = {
        "Не переходи на личности там, где их нет; личности",
        "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами; оскорбления",
        "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.; глупый",
        "Чем ниже интеллект, тем громче оскорбления; интеллект",
        "По этому ключевому слову не найдено цитат.; wrongKey"
    }, delimiter = ';')
    void getInsultTest(String referent, String testCase) {
        assertEquals(referent, new InsultDictionary().getInsult(testCase));
    }
}
