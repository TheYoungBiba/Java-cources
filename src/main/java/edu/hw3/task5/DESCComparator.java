package edu.hw3.task5;

import java.util.Comparator;

public class DESCComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        return o2.getLastName().compareTo(o1.getLastName());
    }
}
