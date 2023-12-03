package edu.hw8.task1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private static final Logger LOGGER = LogManager.getLogger();

    private static final int PORT = 8080;

    private static final String HOST = "localhost";

    private static final Scanner SCANNER = new Scanner(System.in);

    private Client() {}

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        try (
            Socket client = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ) {
            String userInput;
            while (true) {
                userInput = SCANNER.nextLine();
                if (userInput.equals("--close")) {
                    System.exit(0);
                }
                out.println(userInput);
                LOGGER.info("Server: " + in.readLine());
            }
        } catch (IOException e) {
            LOGGER.info(Arrays.toString(e.getStackTrace()));
        }
    }
}
