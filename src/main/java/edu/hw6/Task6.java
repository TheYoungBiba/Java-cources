package edu.hw6;

import java.net.ServerSocket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;

public class Task6 {
    private Task6() {}

    public static void PortScanner() {
        for (int port = 0; port <= 49151; port++) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.close();
                System.out.println("Port " + port + " is available");
            } catch (IOException e) {
                System.out.println("Port " + port + " is busy");
            }
        }

        for (int port = 0; port <= 49151; port++) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();
                System.out.println("Port " + port + " is available");
            } catch (IOException e) {
                System.out.println("Port " + port + " is busy");
            }
        }
    }
}

