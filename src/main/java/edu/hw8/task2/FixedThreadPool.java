package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;

public class FixedThreadPool implements ThreadPool {
    private BlockingQueue<Runnable> taskQueue;

    private Thread[] threads;

    private boolean isShutdown;

    public FixedThreadPool(int countOfThreads) {
        taskQueue = new LinkedBlockingQueue<>();
        threads = new Thread[countOfThreads];
        isShutdown = false;
    }

    @Override
    public void start() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                while (!(taskQueue.isEmpty() && isShutdown)) {
                    Runnable task = taskQueue.poll();
                    if (task != null) {
                        task.run();
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (!isShutdown) {
            taskQueue.add(runnable);
        } else {
            throw new RejectedExecutionException();
        }
    }

    public void shutdown() {
        isShutdown = true;
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    @Override
    public void close() {
        shutdown();
    }
}


