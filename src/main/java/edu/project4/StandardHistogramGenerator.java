//package edu.project4;
//
//import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;
//
//public class StandardHistogramGenerator implements HistogramGenerator {
//    private final double MAX_X_COEFFICIENT = 1.0;
//    private final double MIN_X_COEFFICIENT = -1.0;
//    private final double MAX_Y_COEFFICIENT = 1.0;
//    private final double MIN_Y_COEFFICIENT = -1.0;
//    private Pixel[][] pixels;
//
//
//    public StandardHistogramGenerator() {}
//
//    public Pixel[][] generate(
//        int width,
//        int height,
//        int countOfPoints,
//        int countOfIterations,
//        int countOfSymmetricalParts,
//        int countOfAffineCoefficients,
//        Transformation... transforms
//        ) {
//        pixels = new Pixel[width][height];
//        AffineCoefficientsAndColor[] affineCoefficientsAndColors = initStartCoefficients(countOfAffineCoefficients);
//        for (int i = 0; i < countOfPoints; i++) {
//            localRender(
//                width,
//                height,
//                countOfIterations,
//                countOfSymmetricalParts,
//                affineCoefficientsAndColors,
//                transforms
//            );
//        }
//        return pixels;
//    }
//
//    private void localRender(
//        int width,
//        int height,
//        int countOfIterations,
//        int countOfSymmetricalParts,
//        AffineCoefficientsAndColor[] affineCoefficientsAndColors,
//        Transformation[] transforms
//    ) {
//        Point point = initPoint();
//        final int shiftToSkippableIterations = -20;
//        for (int j = shiftToSkippableIterations; j < countOfIterations; j++) {
//            int coefficientIndex = ThreadLocalRandom.current().nextInt(0, affineCoefficientsAndColors.length);
//            point = affineCoefficientsAndColors[coefficientIndex].transformByCoefficients(point);
//            point = transforms[ThreadLocalRandom.current().nextInt(0, transforms.length)].apply(point);
//            if (j > 0) {
////                double theta = 0;
////                for (int s = 0; s < countOfSymmetricalParts; s++) {
////                    theta += ((2 * Math.PI) / countOfSymmetricalParts);
////                    point = rotate(point, theta);
//                    if (
//                        isInRange(point.x(), MIN_X_COEFFICIENT, MAX_X_COEFFICIENT)
//                        && isInRange(point.y(), MIN_Y_COEFFICIENT, MAX_Y_COEFFICIENT)
//                    ) {
//                        int x1 = width - (int) ((MAX_X_COEFFICIENT - point.x())/(2 * MAX_X_COEFFICIENT) * width);
//                        int y1 = height - (int) ((MAX_Y_COEFFICIENT - point.y())/(2 * MAX_Y_COEFFICIENT) * height);
//                        if (x1 < width && y1 < height) {
//                            if (pixels[x1][y1] == null) {
//                                pixels[x1][y1] = new Pixel(
//                                    x1,
//                                    y1,
//                                    affineCoefficientsAndColors[coefficientIndex].red(),
//                                    affineCoefficientsAndColors[coefficientIndex].green(),
//                                    affineCoefficientsAndColors[coefficientIndex].blue(),
//                                    1
//                                );
//                            } else {
//                                pixels[x1][y1] = correctColor(
//                                    pixels[x1][y1],
//                                    x1,
//                                    y1,
//                                    affineCoefficientsAndColors[coefficientIndex]
//                                );
//                            }
//                        }
//                    }
////                }
//            }
//        }
//    }
//
//    private AffineCoefficientsAndColor[] initStartCoefficients(int countOfCoefficients) {
//        AffineCoefficientsAndColor[] affineCoefficientsAndColors = new AffineCoefficientsAndColor[countOfCoefficients];
//        for (int i = 0; i < affineCoefficientsAndColors.length; i++) {
//            affineCoefficientsAndColors[i] = AffineCoefficientsAndColor.getCoefficients();
//        }
//        return affineCoefficientsAndColors;
//    }
//
//    private Point initPoint() {
//        Random random = new Random();
//        double x = random.nextDouble(MIN_X_COEFFICIENT, MAX_X_COEFFICIENT);
//        double y = random.nextDouble(MIN_Y_COEFFICIENT, MAX_Y_COEFFICIENT);
//        return new Point(x, y);
//    }
//
//    private boolean isInRange(double value, double leftLim, double rightLim) {
//        return value >= leftLim && value <= rightLim;
//    }
//
//    private Pixel correctColor(Pixel pixel, int x1, int y1, AffineCoefficientsAndColor affineCoefficientsAndColor) {
//        return new Pixel(
//            x1,
//            y1,
//            (pixel.red() + affineCoefficientsAndColor.red())/2,
//            (pixel.green() + affineCoefficientsAndColor.green())/2,
//            (pixel.blue() + affineCoefficientsAndColor.blue())/2,
//            pixel.numberOfHits() + 1
//        );
//    }
//
////    public Point rotate(Point point, double theta) {
////        var x = point.x();
////        var y = point.y();
////        double xRotated = x * Math.cos(theta) - y * Math.sin(theta);
////        double yRotated = x * Math.sin(theta) + y * Math.cos(theta);
////        return new Point(xRotated, yRotated);
////    }
//}
