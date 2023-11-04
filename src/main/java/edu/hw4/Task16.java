package edu.hw4;

import edu.hw4.animal.Animal;
import java.util.Comparator;
import java.util.List;

public class Task16 {
    private Task16() {}

    static Comparator<Animal> nameCmp = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.name().compareTo(o2.name());
        }
    };

    static Comparator<Animal> sexCmp = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.sex().compareTo(o2.sex());
        }
    };
    static Comparator<Animal> typeCmp = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.type().compareTo(o2.type());
        }
    };

    public static List<Animal> toSortByTypeSexName(List<Animal> listOfAnimals) {
        return listOfAnimals.stream().sorted(typeCmp.thenComparing(sexCmp.thenComparing(nameCmp))).toList();
    }
}
