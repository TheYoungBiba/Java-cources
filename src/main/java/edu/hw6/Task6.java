package edu.hw6;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task6 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Map<Integer, String> SERVICES = Map.of(
        21, "FTP (File Transfer Protocol)",
        22, "SSH (Secure Shell)",
        80, "HTTP (HyperText Transfer Protocol);",
        97, "SWIFT-RVF (Swift Remote Virtual File Protocol)",
        213, "IPX",
        443, "HTTPS (HyperText Transfer Protocol Secure)",
        843, "Adobe Flash",
        3306, "MySQL Database",
        5353, "Multicast DNS (MDNS)",
        27017, "MongoDB Database"
        );

    private enum Protocol {
        TCP,
        UDP
    }

    private enum Status {
        BUSY,
        FREE
    }

    private Task6() {}

    private static Status scanTcpPort(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            return Status.FREE;
        } catch (Exception e) {
            return Status.BUSY;
        }
    }

    private static Status scanUdpPort(int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            return Status.FREE;
        } catch (Exception e) {
            return Status.BUSY;
        }
    }

    private static void formattedPrint(Protocol protocol, int port) {
        String service = SERVICES.getOrDefault(port, "");
        LOGGER.info(String.format("%s       |  %s  |  %s", protocol.toString(), port, service));
    }

    @SuppressWarnings("MagicNumber")
    public static void portScanner() {
        LOGGER.info("Protocol  |  Port  |  Service");
        for (int port = 0; port <= 49151; port++) {
            if (scanTcpPort(port) == Status.BUSY) {
                formattedPrint(Protocol.TCP, port);
                continue;
            }
            if (scanUdpPort(port) == Status.BUSY) {
                formattedPrint(Protocol.UDP, port);
            }
        }
    }
}

