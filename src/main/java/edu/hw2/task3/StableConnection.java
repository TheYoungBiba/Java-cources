package edu.hw2.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class StableConnection implements Connection {
    private Random isNotConnected;

    public StableConnection(Random isNotConnected) {
        this.isNotConnected = isNotConnected;
    }

    private static final Logger LOGGER = LogManager.getLogger();

    public void execute(String command) throws ConnectionException {
        if (isNotConnected.nextBoolean()) {
            throw new ConnectionException("Connection failed.");
        }
        LOGGER.info("Connected.");
    }

    public void close() throws Exception {}
}
