package edu.hw2.task3;

import edu.hw2.task4.Task4;

public class FailureConnection implements Connection {
    @Override
    public void execute(String command) throws ConnectionException {
        throw new ConnectionException("Connection failed.");
    }

    public void close() throws Exception {}
}
