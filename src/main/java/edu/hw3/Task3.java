package edu.hw3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    private Task3() {}

    public static Map<String, Integer> freqDict(Collection<String> inputList) {
        HashMap<String, Integer> frequencyDictionary = new HashMap<>();
        for (String word: inputList) {
            Integer tempCounterValue = frequencyDictionary.get(word);
            if (tempCounterValue != null) {
                frequencyDictionary.put(word, ++tempCounterValue);
            } else {
                frequencyDictionary.put(word, 1);
            }
        }
        return frequencyDictionary;
    }
}
