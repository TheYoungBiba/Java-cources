package edu.hw4.animal;

public record Animal(String name, Type type, Sex sex, int age, int height, int weight, boolean bites) {
    public int paws() {
        final int QUADRUPENDS = 4;
        final int BIPENDS = 2;
        final int LEGLESS = 0;
        final int EIGHT_LEGGED = 8;
        return switch (type) {
            case CAT, DOG -> QUADRUPENDS;
            case BIRD -> BIPENDS;
            case FISH -> LEGLESS;
            case SPIDER -> EIGHT_LEGGED;
        };
    }
}
