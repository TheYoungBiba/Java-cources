package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.List;

public class Task9 {
    private Task9() {}

    public static Integer countOfPaws(List<Animal> listOfAnimals) {
        return listOfAnimals.stream().reduce(0, (x, y) -> x + y.paws(), Integer::sum);
    }
}
