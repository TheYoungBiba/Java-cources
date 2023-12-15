package edu.project4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class MultithreadHistogramGenerator implements HistogramGenerator {
    private final double MAX_X_COEFFICIENT = 1.0;
    private final double MIN_X_COEFFICIENT = -1.0;
    private final double MAX_Y_COEFFICIENT = 1.0;
    private final double MIN_Y_COEFFICIENT = -1.0;
    private Pixel[][] pixels;


    public MultithreadHistogramGenerator() {}

    public Pixel[][] generate(
        int width,
        int height,
        int countOfPoints,
        int countOfIterations,
        int countOfSymmetricalParts,
        int countOfAffineCoefficients,
        Transformation... transforms
    ) {
        pixels = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = new Pixel(i, j);
            }
        }
        AffineCoefficientsAndColor[] affineCoefficientsAndColors = initStartCoefficients(countOfAffineCoefficients);
        try (ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {
            for (int i = 0; i < countOfPoints; i++) {
                executorService.execute(() -> localRender(
                    width,
                    height,
                    countOfIterations,
                    countOfSymmetricalParts,
                    affineCoefficientsAndColors,
                    transforms
                ));
            }
        }
        return pixels;
    }

    private void localRender(
        int width,
        int height,
        int countOfIterations,
        int countOfSymmetricalParts,
        AffineCoefficientsAndColor[] affineCoefficientsAndColors,
        Transformation[] transforms
    ) {
        Point point = initPoint();
        final int shiftToSkippableIterations = -20;
        for (int j = shiftToSkippableIterations; j < countOfIterations; j++) {
            int coefficientIndex = ThreadLocalRandom.current().nextInt(0, affineCoefficientsAndColors.length);
            point = affineCoefficientsAndColors[coefficientIndex].transformByCoefficients(point);
            point = transforms[ThreadLocalRandom.current().nextInt(0, transforms.length)].apply(point);
            if (j > 0) {
//                double theta = 0;
//                for (int s = 0; s < countOfSymmetricalParts; s++) {
//                    theta += ((2 * Math.PI) / countOfSymmetricalParts);
//                    point = rotate(point, theta);
                if (
                    isInRange(point.x(), MIN_X_COEFFICIENT, MAX_X_COEFFICIENT)
                        && isInRange(point.y(), MIN_Y_COEFFICIENT, MAX_Y_COEFFICIENT)
                ) {
                    int x1 = width - (int) ((MAX_X_COEFFICIENT - point.x())/(2 * MAX_X_COEFFICIENT) * width);
                    int y1 = height - (int) ((MAX_Y_COEFFICIENT - point.y())/(2 * MAX_Y_COEFFICIENT) * height);
                    if (x1 < width && y1 < height) {
                        synchronized (pixels[x1][y1]) {
                            if (pixels[x1][y1].getNumberOfHits() == 0) {
                                pixels[x1][y1].setColor(
                                    affineCoefficientsAndColors[coefficientIndex].red(),
                                    affineCoefficientsAndColors[coefficientIndex].green(),
                                    affineCoefficientsAndColors[coefficientIndex].blue()
                                );
                            } else {
                                pixels[x1][y1].setColor(
                                    (pixels[x1][y1].getRed() + affineCoefficientsAndColors[coefficientIndex].red()) / 2,
                                    (pixels[x1][y1].getGreen() + affineCoefficientsAndColors[coefficientIndex].green()) / 2,
                                    (pixels[x1][y1].getBlue() + affineCoefficientsAndColors[coefficientIndex].blue()) / 2
                                );
                            }
                            pixels[x1][y1].increaseCountOfHits();
                        }
                    }
                }
//                }
            }
        }
    }

    private AffineCoefficientsAndColor[] initStartCoefficients(int countOfCoefficients) {
        AffineCoefficientsAndColor[] affineCoefficientsAndColors = new AffineCoefficientsAndColor[countOfCoefficients];
        for (int i = 0; i < affineCoefficientsAndColors.length; i++) {
            affineCoefficientsAndColors[i] = AffineCoefficientsAndColor.getCoefficients();
        }
        return affineCoefficientsAndColors;
    }

    private Point initPoint() {
        double x = ThreadLocalRandom.current().nextDouble(MIN_X_COEFFICIENT, MAX_X_COEFFICIENT);
        double y = ThreadLocalRandom.current().nextDouble(MIN_Y_COEFFICIENT, MAX_Y_COEFFICIENT);
        return new Point(x, y);
    }

    private boolean isInRange(double value, double leftLim, double rightLim) {
        return value >= leftLim && value <= rightLim;
    }

//    public Point rotate(Point point, double theta) {
//        var x = point.x();
//        var y = point.y();
//        double xRotated = x * Math.cos(theta) - y * Math.sin(theta);
//        double yRotated = x * Math.sin(theta) + y * Math.cos(theta);
//        return new Point(xRotated, yRotated);
//    }
}

