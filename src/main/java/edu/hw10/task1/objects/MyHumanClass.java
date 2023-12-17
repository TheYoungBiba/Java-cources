package edu.hw10.task1.objects;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class MyHumanClass {
    private int age;
    private String name;

    public MyHumanClass() {
    }

    public MyHumanClass(@NotNull String name, @Min(0) @Max(100) int age) {
        this.name = name;
        this.age = age;
    }

    @SuppressWarnings("MagicNumber")
    public static MyHumanClass getInstanceWithoutParams() {
        MyHumanClass human = new MyHumanClass();
        human.name = "Kirill";
        human.age = Period.between(LocalDate.of(2004, Month.JANUARY, 29), LocalDate.now()).getYears();
        return human;
    }

    public static MyHumanClass getInstance(@NotNull String name, @Min(0) @Max(100) int age) {
        MyHumanClass human = new MyHumanClass();
        human.name = name;
        human.age = age;
        return human;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
