package edu.hw2.task3;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FaultyConnection implements Connection {
    private Random isNotConnected;

    public FaultyConnection(Random isNotConnected) {
        this.isNotConnected = isNotConnected;
    }

    private static final Logger LOGGER = LogManager.getLogger();

    public void execute(String command) throws ConnectionException {
        if (isNotConnected.nextBoolean()) {
            throw new ConnectionException("Connection failed.");
        }
        LOGGER.info("Connected with faulty connection.");
    }

    public void close() throws Exception {}
}
