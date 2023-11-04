package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task18 {
    private Task18() {}

    private static Comparator<Animal> weightCmp = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return Integer.compare(o1.weight(), o2.weight());
        }
    };

    public static Animal heaviestFish(List<Animal>... listsOfAnimals) {
        return Arrays.stream(listsOfAnimals)
            .flatMap(list -> list.stream())
            .filter(animal -> animal.type().equals(Type.FISH))
            .max(weightCmp)
            .orElse(null);
    }

}
