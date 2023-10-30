package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Type;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task6 {
    private Task6() {}

    public static Map<Type, Animal> toMostHeavyAnimalMap(List<Animal> listOfAnimals) {
        Map<Type, Animal> mostHeavyAnimalMap = new HashMap<>();
        Comparator<Animal> weightCmp = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Integer.compare(o1.weight(), o2.weight());
            }
        };
        for (Type type: Type.values()) {
            mostHeavyAnimalMap.put(type, listOfAnimals.stream().filter(animal -> animal.type() == type).max(weightCmp)
                .orElse(null));
        }
        return mostHeavyAnimalMap;
    }
}
