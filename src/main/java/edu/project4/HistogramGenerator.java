package edu.project4;

public interface HistogramGenerator {
    Pixel[][] generate(
        int width,
        int height,
        int countOfPoints,
        int countOfIterations,
        int countOfSymmetricalParts,
        int countOfAffineCoefficients,
        Transformation... transforms
    );
}
