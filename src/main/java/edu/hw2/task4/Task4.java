package edu.hw2.task4;

public class Task4 {
    private Task4() {}
    public static CallingInfo callingInfo() {
        Thread currentThread = Thread.currentThread();
        StackTraceElement[] calledMethods = currentThread.getStackTrace();
        StackTraceElement currentElement = calledMethods[2];
        return new CallingInfo(currentElement.getClassName(), currentElement.getMethodName());
    }
}
