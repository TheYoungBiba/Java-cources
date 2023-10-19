package edu.hw2.task3;

public class FailureConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new FailureConnection();
    }
}
