package edu.hw7.task1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private final AtomicInteger counter = new AtomicInteger();

    private final int cores = Runtime.getRuntime().availableProcessors();

    public Counter() {}

    private static final Logger LOGGER = LogManager.getLogger();

    public void targetIncrement(int target) {
        Thread[] threads = new Thread[cores];
        threads[0] = getIncreaseThread(target / cores + target % cores);
        for (int i = 1; i < cores; i++) {
            threads[i] = getIncreaseThread(target / cores);
        }
        for (Thread thread: threads) {
            thread.start();
        }
        try {
            for (Thread thread: threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Arrays.stream(e.getStackTrace()).forEach(LOGGER::info);
        }
    }

    public void increment() {
        counter.incrementAndGet();
    }

    public void decrement() {
        counter.decrementAndGet();
    }

    public int get() {
        return counter.get();
    }

    private Thread getIncreaseThread(int localTarget) {
        return new Thread(() -> {
            int incrementor = 0;
            for (int i = 0; i < localTarget; i++) {
                incrementor++;
            }
            counter.addAndGet(incrementor);
        });
    }
}
