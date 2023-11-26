package edu.hw7.task4;

public class Benchmark {
    private Benchmark() {}


    public static double speedIncrease() {
        long duration = 0;
        for(int i = 0; i < 5; i++) {
            long exectness = ((long) (1000_000 * Math.pow(10, i)));
            long multithreadStart = System.currentTimeMillis();
            new MultithreadMonteCarloMethod().calculatePI(exectness);
            long multithreadEnd = System.currentTimeMillis();
            long singleThreadStart = System.currentTimeMillis();
            new SingleThreadMonteCarloMethod().calculatePI(exectness);
            long singleThreadEnd = System.currentTimeMillis();
            duration += (singleThreadEnd - singleThreadStart) - (multithreadEnd - multithreadStart);
        }
        return ((double) duration) / 5;
        //    76510.4
    }



    public static double delta(long simulations) {
        double delta = 0;
        for (int i = 0; i < 10; i++) {
            delta += new MultithreadMonteCarloMethod().calculatePI(simulations);
        }
        return ((delta - Math.PI * 10) / (Math.PI * 10)) * 100;
        //    0.0028707225968263384
        //    -0.001617319474409715
        //    -6.159675020549806E-4
    }
}
