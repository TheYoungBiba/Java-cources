package edu.hw9.task1;

public class StatThread implements Runnable {
    private final String metricName;

    private final double[] data;

    private Collector collector;

    public StatThread(String metricName, double[] data, Collector collector) {
        this.metricName = metricName;
        this.data = data;
        this.collector = collector;
    }

    @Override
    public void run() {
        collector.push(metricName, data);
    }
}
