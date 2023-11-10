package edu.hw5;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        for (int yaer = 1823; yaer < 3000; yaer++) {
//            System.out.println(Task2.fridayThe13th(yaer));
//        }
//        System.out.println(Task2.fridayThe13th(2023));
//        System.out.println(LocalDate.of(2023, 1, 13).compareTo(LocalDate.of(2023, 10, 13)));
//        System.out.println(Task2.findFirstFridayThe13th(LocalDate.now()));
        System.out.println(Task2.findFirstFridayThe13th(LocalDate.now().plusYears(2)));
    }
}
