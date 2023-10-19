package edu.hw2;

import edu.hw2.task1.*;
import edu.hw2.task2.*;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.FailureConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random1 = new Random(11);
        Random random2 = new Random(1);
//        new PopularCommandExecutor(new DefaultConnectionManager(random1, random2), 5).updatePackages();
        new PopularCommandExecutor(new FailureConnectionManager(), 5).updatePackages();
    }
}
