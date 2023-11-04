package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task15 {
    private Task15() {}

    public static Map<Type, Integer> toFindSumWeightOfEachAnimalType(List<Animal> listOfAnimals, int k, int l) {
        Map<Type, Integer> sumWeight = new HashMap<>();
        for (Type type: Type.values()) {
            sumWeight.put(type, listOfAnimals.stream().filter(animal -> animal.age() >= k && animal.age() <= l
                    && animal.type() == type).reduce(0, (sum, animal) -> sum + animal.weight(), Integer::sum));
        }
        return sumWeight;
    }
}
