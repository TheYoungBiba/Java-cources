package edu.hw5;

import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        String str = "2022-03-12, 09:20 - 2022-03-12, 23:50";
//        String temp = str.replace(", ", "T");
//        System.out.println(str);
//        System.out.println(temp);
//        Task1.toInstantFormat(str).forEach(System.out::println);
        System.out.println(Duration.between(Instant.parse("2022-03-12T20:20:00Z"), Instant.parse("2022-03-12T23:50:00Z"))
            .plus(Duration.between(Instant.parse("2022-04-01T21:30:00Z"), Instant.parse("2022-04-02T01:20:00Z"))));
    }
}
