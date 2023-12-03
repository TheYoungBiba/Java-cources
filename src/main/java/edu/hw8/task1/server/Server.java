package edu.hw8.task1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final int PORT = 8080;

    private Server() {}

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            LOGGER.info("Server started.");
            ExecutorService threadPool = Executors.newCachedThreadPool();
            while (true) {
                Socket client = server.accept();
                Runnable localServer = new LocalServer(client);
                threadPool.execute(localServer);
            }
        } catch (IOException e) {
            LOGGER.info(Arrays.toString(e.getStackTrace()));
        }
    }
}
