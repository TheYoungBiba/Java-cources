package edu.hw3.task6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.jetbrains.annotations.NotNull;

public record Stock(String ticker, double currentPrice) implements Comparable<Stock> {
    @Override
    public int compareTo(@NotNull Stock o) {
        BigDecimal difference = new BigDecimal(this.currentPrice - o.currentPrice()).setScale(0, RoundingMode.UP);
        return ((int) difference.doubleValue());
    }
}
