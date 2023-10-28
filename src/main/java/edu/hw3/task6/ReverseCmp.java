package edu.hw3.task6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

public class ReverseCmp implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
        BigDecimal difference = new BigDecimal(o2.currentPrice() - o1.currentPrice()).setScale(0, RoundingMode.UP);
        return ((int) difference.doubleValue());
    }
}
