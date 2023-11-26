package edu.hw7.task4;

import java.util.Random;

public class SingleThreadMonteCarloMethod implements MonteCarloMethod {
    private long totalCount = 0;

    private long circleCount = 0;

    private Random random = new Random();

    private final double width;

    private final double radius;

    public SingleThreadMonteCarloMethod(double radius) {
        this.radius = radius;
        width = radius * 2;
    }

    public SingleThreadMonteCarloMethod() {
        radius = 1;
        width = 2;
    }

    @SuppressWarnings("MagicNumber")
    @Override
    public double calculatePI(long exactness) {
        for (long i = 0; i < exactness; i++) {
            Coordinate tempCoord = getRandomCoord();
            circleCount += isInCircle(tempCoord) ? 1 : 0;
            totalCount++;
        }
        return 4D * ((double) circleCount / (double) totalCount);
    }

    private Coordinate getRandomCoord() {
        return new Coordinate(random.nextDouble() * width - radius, random.nextDouble() * width - radius);
    }

    private boolean isInCircle(Coordinate coord) {
        return Math.pow(coord.x(), 2) + Math.pow(coord.y(), 2) <= Math.pow(radius, 2);
    }
}
