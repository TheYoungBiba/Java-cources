package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleDisplay {
    private static final Logger LOGGER = LogManager.getLogger();

    private ConsoleDisplay() {}

    public static void toStart() {
        LOGGER.info("\nDo You want to start game? [Y/N]");
    }

    public static void startMessage(String answer, int maxCountOfAttempts) {
        LOGGER.info("\nThe game is started!\nYour word is " + answer
            + ". Your count of attempts: " + maxCountOfAttempts + ".");
    }

    public static void winMessage(String answer) {
        LOGGER.info("\nYou win!");
    }

    public static void looseMessage(String answer) {
        LOGGER.info("\nYou loose.\nYour word was " + answer + ".");
    }

    private static String partOfIntermediateAnswer(String currentAnswer, int currentCountOfAttempts) {
        return "\nThe condition of your answer is: " + currentAnswer
            + "\nYou still have " + currentCountOfAttempts + " attempts.";
    }

    public static void rightGuessMessage(String currentAnswer, int currentCountOfAttempts) {
        LOGGER.info("\nYour guess is right. " + partOfIntermediateAnswer(currentAnswer, currentCountOfAttempts));
    }

    public static void wrongGuessMessage(String currentAnswer, int currentCountOfAttempts) {
        LOGGER.info("\nYour guess is wrong. " + partOfIntermediateAnswer(currentAnswer, currentCountOfAttempts));
    }
}
