package edu.project4;

import edu.project4.transformations.CardioidTransform;
import edu.project4.transformations.DiscTransform;
import edu.project4.transformations.PolarTransform;
import edu.project4.transformations.SinTransform;
import edu.project4.transformations.SphereTransform;
import java.nio.file.Path;

public class Main {
    private Main() {}

//    TODO добавить пооержку задания цвета вручную

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        FractalFlame flame = new FractalFlame(
            3840,
            2160,
            new MultithreadHistogramGenerator(),
            300,
            100_000,
            3,
            20,
            new CardioidTransform(),
            new DiscTransform(),
            new SphereTransform(),
            new SinTransform(),
            new PolarTransform()
        );
        FlameRenderer.render(
            FlameRenderer.logarithmicGammaCorrection(flame, 0.2),
            "png",
            Path.of("src", "main", "java", "edu", "project4", "images")
        );
    }
}
