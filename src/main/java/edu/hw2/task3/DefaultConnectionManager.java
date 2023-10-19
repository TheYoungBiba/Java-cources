package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    public Random isNotConnected;
    public Random isFailureConnection;

    public DefaultConnectionManager(Random isFailureConnection, Random isNotConnected) {
        this.isNotConnected = isNotConnected;
        this.isFailureConnection = isFailureConnection;
    }

    @Override
    public Connection getConnection() {
        if (isFailureConnection.nextBoolean()) {
            return new FailureConnection();
        }
        return new StableConnection(isNotConnected);
    }
}
