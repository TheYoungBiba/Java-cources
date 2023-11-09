package edu.hw4.task19_20;

import edu.hw4.animal.Animal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Task19 {
    private Task19() {}

    public static Map<String, Set<ValidationError>> findExceptions(List<Animal> listOfAnimals) {
        return listOfAnimals.stream().collect(Collectors.toMap(Animal::name, animal -> {
                Set<ValidationError> errors = new HashSet<>();
                Collections.addAll(
                    errors,
                    ValidationError.invalidHeight(animal), ValidationError.invalidWeight(animal),
                    ValidationError.invalidAge(animal), ValidationError.invalidName(animal)
                );
                return errors.stream().filter(Objects::nonNull).collect(Collectors.toSet());
            })).entrySet().stream().filter(s -> !s.getValue().isEmpty()).collect(Collectors
            .toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}



