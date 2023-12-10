package edu.hw9.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAdder;

class StatsCollector {
    private Map<String, DoubleAdder> sums = new HashMap<>();
    private Map<String, DoubleAdder> counts = new HashMap<>();
    private Map<String, Double> maxValues = new HashMap<>();
    private Map<String, Double> minValues = new HashMap<>();

    public void push(String metricName, double[] data) {
        sums.putIfAbsent(metricName, new DoubleAdder());
        counts.putIfAbsent(metricName, new DoubleAdder());

        for (double value: data) {
            sums.get(metricName).add(value);
            counts.get(metricName).add(1);

            maxValues.put(metricName, Math.max(maxValues.getOrDefault(metricName, Double.NEGATIVE_INFINITY), value));
            minValues.put(metricName, Math.min(minValues.getOrDefault(metricName, Double.POSITIVE_INFINITY), value));
        }
    }

    public Map<String, Double> stats() {
        Map<String, Double> result = new HashMap<>();

        for (String metricName: sums.keySet()) {
            double sum = sums.get(metricName).doubleValue();
            double count = counts.get(metricName).doubleValue();
            double average = sum / count;
            double max = maxValues.get(metricName);
            double min = minValues.get(metricName);

            result.put(metricName + "_sum", sum);
            result.put(metricName + "_average", average);
            result.put(metricName + "_max", max);
            result.put(metricName + "_min", min);
        }

        return result;
    }
}

