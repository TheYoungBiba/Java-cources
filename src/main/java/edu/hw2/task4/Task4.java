package edu.hw2.task4;

public class Task4 {
    private Task4() {}

    public static CallingInfo callingInfo() {
        Thread currentThread = Thread.currentThread();
        StackTraceElement[] calledMethods = currentThread.getStackTrace();
        final int INDEX_OF_METHOD_WHERE_CALLED = 2;
        StackTraceElement currentElement = calledMethods[INDEX_OF_METHOD_WHERE_CALLED];
        return new CallingInfo(currentElement.getClassName(), currentElement.getMethodName());
    }
}
