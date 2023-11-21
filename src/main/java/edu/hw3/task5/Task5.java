package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task5 {

    private Task5() {}

    private static Contact contactInit(String name) {
        int indexOfSpace = name.indexOf(" ");
        if (indexOfSpace == -1) {
            return new Contact(name);
        }
        return new Contact(name.substring(0, indexOfSpace), name.substring(indexOfSpace + 1));
    }

    private static boolean isValid(String[] masOfNamesToParse) {
        for (String name: masOfNamesToParse) {
            if (name.length() - name.replace(" ", "").length() > 1) {
                return false;
            }
        }
        return true;
    }

    public static Contact[] parseContacts(String[] masOfNamesToParse, String typeOfSort) {
        if (masOfNamesToParse == null || masOfNamesToParse.length == 0) {
            return new Contact[0];
        }
        if (!isValid(masOfNamesToParse)) {
            throw new IllegalArgumentException("Incorrect input of names");
        }
        ArrayList<Contact> listOfContacts = new ArrayList<>();
        for (String name: masOfNamesToParse) {
            listOfContacts.add(contactInit(name));
        }
        switch (typeOfSort) {
            case ("ASC"): {
                Comparator asc = new ASCComparator();
                Collections.sort(listOfContacts, asc);
                return listOfContacts.toArray(new Contact[0]);
            }
            case ("DESC"): {
                Comparator desc = new DESCComparator();
                Collections.sort(listOfContacts, desc);
                return listOfContacts.toArray(new Contact[0]);
            }
            default: {
                throw new IllegalArgumentException("Incorrect type of sort, must be \"ASC\" or \"DESC\".");
            }
        }
    }
}
