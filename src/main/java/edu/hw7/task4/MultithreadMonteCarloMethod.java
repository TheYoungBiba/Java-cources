package edu.hw7.task4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultithreadMonteCarloMethod implements MonteCarloMethod {
    private final AtomicLong totalCount = new AtomicLong();

    private final AtomicLong circleCount = new AtomicLong();

    private final int cores;

    private final double width;

    private final double radius;

    private static final Logger LOGGER = LogManager.getLogger();

    public MultithreadMonteCarloMethod(double radius) {
        cores = Runtime.getRuntime().availableProcessors();
        this.radius = radius;
        width = radius * 2;
    }

    public MultithreadMonteCarloMethod() {
        cores = Runtime.getRuntime().availableProcessors();
        radius = 1;
        width = 2;
    }

    @SuppressWarnings("MagicNumber")
    @Override
    public double calculatePI(long exactness) {
        Thread[] threads = new Thread[cores];
        threads[0] = getCalculateThread(exactness / cores + exactness % cores);
        for (int i = 1; i < cores; i++) {
            threads[i] = getCalculateThread(exactness / cores);
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
        return 4D * (((double) circleCount.get()) / ((double) totalCount.get()));
    }

    private Thread getCalculateThread(long localExactness) {
        return new Thread(() -> {
            long localTotalCount = 0;
            long localCircleCount = 0;
            for (long i = 0; i < localExactness; i++) {
                Coordinate tempCoord = new Coordinate(
                    ThreadLocalRandom.current().nextDouble() * width - radius,
                    ThreadLocalRandom.current().nextDouble() * width - radius
                );
                localCircleCount += isInCircle(tempCoord) ? 1 : 0;
                localTotalCount++;
            }
            totalCount.addAndGet(localTotalCount);
            circleCount.addAndGet(localCircleCount);
        });
    }

    private boolean isInCircle(Coordinate coord) {
        return Math.pow(coord.x(), 2) + Math.pow(coord.y(), 2) <= Math.pow(radius, 2);
    }
}
