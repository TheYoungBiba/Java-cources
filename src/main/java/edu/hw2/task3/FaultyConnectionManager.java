package edu.hw2.task3;

import java.util.Random;

public class FaultyConnectionManager implements ConnectionManager {
    private Random isNotConnected;

    public FaultyConnectionManager(Random isNotConnected) {
        this.isNotConnected = isNotConnected;
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(isNotConnected);
    }
}
