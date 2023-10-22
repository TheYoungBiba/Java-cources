package edu.hw2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    public Random isFaultyConnection;
    public Random isNotConnected;

    public DefaultConnectionManager(Random isFaultyConnection, Random isNotConnected) {
        this.isFaultyConnection = isFaultyConnection;
        this.isNotConnected = isNotConnected;
    }

    @Override
    public Connection getConnection() {
        if (isFaultyConnection.nextBoolean()) {
            return new FaultyConnection(isNotConnected);
        }
        return new StableConnection();
    }
}
