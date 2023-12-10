package edu.project4;

import java.awt.Color;
import java.util.Random;

public record AffineCoefficientsAndColor(double a, double b, double c, double d, double e, double f, Color color) {
    public static AffineCoefficientsAndColor getCoefficients() {
        double a = getRandomVal(1.5);
        double b = getRandomVal(1.5);
        double c = getRandomVal(3.5);
        double d = getRandomVal(1.5);
        double e = getRandomVal(1.5);
        double f = getRandomVal(3.5);
        while (!isValidCoefficients(a, b, d, e)) {
            a = getRandomVal(1.5);
            b = getRandomVal(1.5);
            d = getRandomVal(1.5);
            e = getRandomVal(1.5);
        }
        Random random = new Random();
        return new AffineCoefficientsAndColor(a, b, c, d, e, f,
            new Color(
                random.nextInt(0, 256),
                random.nextInt(0, 256),
                random.nextInt(0, 256)
            )
        );
    }

    public static AffineCoefficientsAndColor getCoefficients(double range) {
        double a = getRandomVal(range);
        double b = getRandomVal(range);
        double c = getRandomVal(range + 2);
        double d = getRandomVal(range);
        double e = getRandomVal(range);
        double f = getRandomVal(range + 2);
        while (!isValidCoefficients(a, b, d, e)) {
            a = getRandomVal(range);
            b = getRandomVal(range);
            d = getRandomVal(range);
            e = getRandomVal(range);
        }
        Random random = new Random();
        return new AffineCoefficientsAndColor(a, b, c, d, e, f,
            new Color(
                random.nextInt(0, 256),
                random.nextInt(0, 256),
                random.nextInt(0, 256)
            )
        );
    }

    public Point transformByCoefficients(Point point) {
        double x = point.x() * this.a + point.y() * this.b + this.c;
        double y = point.x() * this.d + point.y() * this.e + this.f;
        return new Point(x, y);
    }

    private static boolean isValidCoefficients(double a, double b, double d, double e) {
        if (!(Math.pow(a, 2) + Math.pow(d, 2) < 1)) {
            return false;
        }
        if (!(Math.pow(b, 2) + Math.pow(e, 2) < 1)) {
            return false;
        }
        return Math.pow(a, 2) + Math.pow(d, 2) + Math.pow(b, 2) + Math.pow(e, 2) < 1 + Math.pow(a * e - b * d, 2);
    }

    private static double getRandomVal(double range) {
        Random random = new Random();
        return range * random.nextDouble() * Math.pow(-1, random.nextInt(0, 2));
    }
}
