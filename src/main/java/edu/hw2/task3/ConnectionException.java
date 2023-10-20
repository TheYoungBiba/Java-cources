package edu.hw2.task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String exceptionMessage) {
        super(exceptionMessage);
    }
    public ConnectionException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }

}
