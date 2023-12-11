package edu.hw9.task1;

import java.util.Map;

public interface Collector {
    void push(String metricName, double[] data);

    Map<String, Double> getStats();
}
