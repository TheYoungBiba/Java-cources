package edu.hw3.task6;

import java.util.Collections;
import java.util.PriorityQueue;

public class Task6 implements StockMarket {
    public Task6() {}

    private PriorityQueue<Stock> stockBook = new PriorityQueue<>();

    @Override
    public void add(Stock stock) {
        stockBook.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockBook.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        PriorityQueue<Stock> tempStockBook = new PriorityQueue<>(new ReverseCmp());
        for (Stock stock: stockBook) {
            tempStockBook.add(stock);
        }
        return tempStockBook.peek();
    }
}
