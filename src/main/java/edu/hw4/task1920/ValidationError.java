package edu.hw4.task1920;

import edu.hw4.animal.Animal;

public class ValidationError extends RuntimeException {
    public ValidationError(String message) {
        super(message);
    }

    public static ValidationError invalidName(Animal animal) {
        final int STO = 100;
        if (animal.name().length() > STO) {
            return new ValidationError("Too long name");
        }
        return null;
    }

    public static ValidationError invalidAge(Animal animal) {
        if (animal.age() < 0) {
            return new ValidationError("Incorrect age.");
        }
        return null;
    }

    public static ValidationError invalidWeight(Animal animal) {
        if (animal.weight() < 0) {
            return new ValidationError("Incorrect weight.");
        }
        return null;
    }

    public static ValidationError invalidHeight(Animal animal) {
        if (animal.height() < 0) {
            return new ValidationError("Incorrect height.");
        }
        return null;
    }
}
