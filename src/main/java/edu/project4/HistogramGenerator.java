package edu.project4;

import edu.project4.transformations.CardioidTransform;
import edu.project4.transformations.DiscTransform;
import edu.project4.transformations.PolarTransform;
import edu.project4.transformations.SinTransform;
import edu.project4.transformations.SphereTransform;
import java.util.Random;

public class HistogramGenerator {
    private Transformation[] transforms;

    private AffineCoefficientsAndColor[] affineCoefficientsAndColors;

    private final int width;

    private final int height;

    public HistogramGenerator(int width, int height, Transformation... transforms) {
        this.width = width;
        this.height = height;
        affineCoefficientsAndColors = initStartCoefficients();
        this.transforms = transforms;
    }

    public HistogramGenerator(int width, int height) {
        this.width = width;
        this.height = height;
        affineCoefficientsAndColors = initStartCoefficients();
        transforms = new Transformation[5];
        transforms[0] = new SinTransform();
        transforms[1] = new SphereTransform();
        transforms[2] = new PolarTransform();
        transforms[3] = new DiscTransform();
        transforms[4] = new CardioidTransform();
    }

    public FractalImage generate(int countOfIterations) {
        Random random = new Random();
        double maxXCoefficient = ((double) Math.max(width, height) / Math.min(width, height));
        for (int i = 0; i < affineCoefficientsAndColors.length; i++) {
            Point tempPoint = new Point(
                random.nextDouble() * maxXCoefficient * Math.pow(-1, random.nextInt(0, 2)),
                random.nextDouble() * Math.pow(-1, random.nextInt(0, 2))
            );
            for (int j = -20; j < countOfIterations; j++) {
                tempPoint = affineCoefficientsAndColors[random.nextInt(0, affineCoefficientsAndColors.length)]
                    .transformByCoefficients(tempPoint);
//                if (j > 0 && )
            }
        }
        return null;
    }

    private AffineCoefficientsAndColor[] initStartCoefficients(int countOfCoefficients) {
        AffineCoefficientsAndColor[] affineCoefficientsAndColors = new AffineCoefficientsAndColor[countOfCoefficients];
        for (int i = 0; i < affineCoefficientsAndColors.length; i++) {
            affineCoefficientsAndColors[i] = AffineCoefficientsAndColor.getCoefficients();
        }
        return affineCoefficientsAndColors;
    }

    private AffineCoefficientsAndColor[] initStartCoefficients() {
        Random random = new Random();
        AffineCoefficientsAndColor[] affineCoefficientsAndColors
            = new AffineCoefficientsAndColor[random.nextInt(4,17)];
        for (int i = 0; i < affineCoefficientsAndColors.length; i++) {
            affineCoefficientsAndColors[i] = AffineCoefficientsAndColor.getCoefficients();
        }
        return affineCoefficientsAndColors;
    }
}
