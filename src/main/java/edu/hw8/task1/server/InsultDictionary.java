package edu.hw8.task1.server;

import java.util.HashMap;
import java.util.Map;

public class InsultDictionary implements Dictionary {
    private Map<String, String> insults;

    public InsultDictionary() {
        insults = Map.of(
            "личности", "Не переходи на личности там, где их нет",
            "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не "
                + "за горами",
            "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто "
                + "бог идиотизма.",
            "интеллект", "Чем ниже интеллект, тем громче оскорбления"
        );
    }

    public InsultDictionary(String... keyWordsAndInsults) {
        if (keyWordsAndInsults.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid count of keys or insults.");
        }
        insults = new HashMap<>();
        for (int i = 0; i < keyWordsAndInsults.length; i += 2) {
            insults.put(keyWordsAndInsults[i], keyWordsAndInsults[i + 1]);
        }
    }

    public InsultDictionary(HashMap<String, String> mapOfInsults) {
        insults = mapOfInsults;
    }

    public String getInsult(String keyWord) {
        if (!insults.containsKey(keyWord)) {
            return "По этому ключевому слову не найдено цитат.";
        }
        return insults.get(keyWord);
    }
}
