package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private Task3() {}

    public static Map<Type, Integer> toMapCounter(List<Animal> listOfAnimals) {
        Map<Type, Integer> counter = new HashMap<>();
        for (Type type: Type.values()) {
            counter.put(type, (int) listOfAnimals.stream().filter(animal -> animal.type().equals(type)).count());
        }
        return counter;
    }
}
