package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private final AtomicInteger counter = new AtomicInteger();

    public Counter() {}

    public void targetIncrement(int target) {
        Thread thread1 = getIncreaseThread(target / 8 + target % 8);
        Thread thread2 = getIncreaseThread(target / 8);
        Thread thread3 = getIncreaseThread(target / 8);
        Thread thread4 = getIncreaseThread(target / 8);
        Thread thread5 = getIncreaseThread(target / 8);
        Thread thread6 = getIncreaseThread(target / 8);
        Thread thread7 = getIncreaseThread(target / 8);
        Thread thread8 = getIncreaseThread(target / 8);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
