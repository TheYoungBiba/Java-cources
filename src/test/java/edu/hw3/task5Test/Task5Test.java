package edu.hw3.task5Test;

import edu.hw3.task5.Contact;
import edu.hw3.task5.Task5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    private static Stream<Arguments> provideTestCasesForParseContactsTest() {
        String[] simpleTest = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        Contact[] referentSimpleTestASC = {new Contact("Thomas", "Aquinas"), new Contact("Rene", "Descartes"),
            new Contact("David", "Hume"), new Contact("John", "Locke")};
        Contact[] referentSimpleTestDESC = {new Contact("John", "Locke"), new Contact("David", "Hume"),
            new Contact("Rene", "Descartes"), new Contact("Thomas", "Aquinas")};
        String[] testCaseWithDeepComparation = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        Contact[] referentWithDeepComparationTestDESC = {new Contact("Carl", "Gauss"), new Contact("Leonhard", "Euler"),
            new Contact("Paul", "Erdos")};
        Contact[] referentWithDeepComparationTestASC = {new Contact("Paul", "Erdos"), new Contact("Leonhard", "Euler"),
            new Contact("Carl", "Gauss")};
        String[] testCaseWithNoLastName = {"John", "Thomas Aquinas", "David Hume", "Rene"};
        Contact[] referentWithNoLastNameTestASC = {new Contact("Thomas", "Aquinas"), new Contact("David", "Hume"),
            new Contact("John"), new Contact("Rene")};
        Contact[] referentWithNoLastNameTestDESC = {new Contact("Rene"), new Contact("John"),
            new Contact("David", "Hume"), new Contact("Thomas", "Aquinas")};
        return Stream.of(
            Arguments.of(simpleTest, "ASC", referentSimpleTestASC),
            Arguments.of(simpleTest, "DESC", referentSimpleTestDESC),
            Arguments.of(testCaseWithDeepComparation, "ASC", referentWithDeepComparationTestASC),
            Arguments.of(testCaseWithDeepComparation, "DESC", referentWithDeepComparationTestDESC),
            Arguments.of(testCaseWithNoLastName, "ASC", referentWithNoLastNameTestASC),
            Arguments.of(testCaseWithNoLastName, "DESC", referentWithNoLastNameTestDESC)
        );
    }

    private String arrayOfContactsToString(Contact[] input) {
        StringBuilder output = new StringBuilder();
        for (Contact contact: input) {
            output.append(contact.toString() + ", ");
        }
        output.delete(output.length() - 2, output.length() - 1);
        return output.toString();
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForParseContactsTest")
    void parseContactsTest(String[] testCase, String typeOfSortTestcase, Contact[] referent) {
        Contact[] testResult = Task5.parseContacts(testCase, typeOfSortTestcase);
        assertEquals(arrayOfContactsToString(testResult), arrayOfContactsToString(referent));
    }

    private static Stream<Arguments> provideTestCasesForParseContactsEmptyTest() {
        return Stream.of(
            Arguments.of(new String[0], "DESC"),
            Arguments.of(null, "DESC")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForParseContactsEmptyTest")
    void parseContactsEmptyTest(String[] testCase, String typeOfSortTestcase) {
        Contact[] testResult = Task5.parseContacts(testCase, typeOfSortTestcase);
        assertTrue(testResult.length == 0);
    }

    @Test
    void parseContactsTestWithIncorrectInputException() {
        String[] testCase = {"John Fon Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Task5.parseContacts(testCase, "ASC");
        });
        assertEquals("Incorrect input of names", e.getMessage());
    }

    @Test
    void parseContactsTestWithIncorrectTypeSortException() {
        String[] testCase = {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Task5.parseContacts(testCase, "asc");
        });
        assertEquals("Incorrect type of sort, must be \"ASC\" or \"DESC\".", e.getMessage());
    }
}
