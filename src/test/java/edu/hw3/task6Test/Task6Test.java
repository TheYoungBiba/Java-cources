package edu.hw3.task6Test;

import edu.hw3.task6.Stock;
import edu.hw3.task6.Task6;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    Task6 test = new Task6();

    @Test
    void mostValuableStockTest() {
        test.add(new Stock("SBER", 269.69));
        test.add(new Stock("SBERP", 269.24));
        test.add(new Stock("POLY", 547.3));
        assertEquals(new Stock("POLY", 547.3), test.mostValuableStock());
    }
}
