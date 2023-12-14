package edu.hw8.task1.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocalServer implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Socket client;

    private final Dictionary insultDictionary;

    public LocalServer(Socket client) {
        this.client = client;
        insultDictionary = new InsultDictionary();
    }

    public LocalServer(Socket client, Dictionary insultDictionary) {
        this.client = client;
        this.insultDictionary = insultDictionary;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))
        ) {
            String tempKeyWord = in.readLine();
            while (!tempKeyWord.equals("--close")) {
                out.write(insultDictionary.getInsult(tempKeyWord) + "\n");
                out.flush();
                tempKeyWord = in.readLine();
            }
            client.close();
        } catch (IOException e) {
            LOGGER.error("Request processing error.");
        }
    }
}
