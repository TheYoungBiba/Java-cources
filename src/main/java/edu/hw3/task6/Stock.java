package edu.hw3.task6;

import org.jetbrains.annotations.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;

public record Stock(String ticker, double currentPrice) implements Comparable<Stock> {
    @Override
    public int compareTo(@NotNull Stock o) {
        BigDecimal difference = new BigDecimal(this.currentPrice - o.currentPrice()).setScale(0, RoundingMode.UP);
        return (int)(difference.doubleValue());
    }
}
