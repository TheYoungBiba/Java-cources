package edu.hw4.task1920;

import edu.hw4.animal.Animal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task20 {
    private Task20() {}

    public static Map<String, String> toReadable(List<Animal> listOfAnimals) {
        return listOfAnimals.stream().collect(Collectors.toMap(Animal::name, animal -> {
                StringBuilder stringBuilder = new StringBuilder();
                if (ValidationError.invalidHeight(animal) != null) {
                    stringBuilder.append("height, ");
                }
                if (ValidationError.invalidWeight(animal) != null) {
                    stringBuilder.append("weight, ");
                }
                if (ValidationError.invalidAge(animal) != null) {
                    stringBuilder.append("age, ");
                }
                if (ValidationError.invalidName(animal) != null) {
                    stringBuilder.append("name, ");
                }
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
                }
                return stringBuilder.toString();
            })).entrySet().stream().filter(s -> !s.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

