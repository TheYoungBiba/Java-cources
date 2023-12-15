package edu.project4;

import edu.project4.transformations.CardioidTransform;
import edu.project4.transformations.DiscTransform;
import edu.project4.transformations.PolarTransform;
import edu.project4.transformations.SinTransform;
import edu.project4.transformations.SphereTransform;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private Main() {}

    public static void main(String[] args) throws IOException {
        FlameRenderer.render(
            new FractalFlame(
                3840,
                2160,
                new MultithreadHistogramGenerator(),
                100,
                110_000,
                3,
                10,
                new CardioidTransform(),
                new DiscTransform(),
                new SphereTransform(),
                new SinTransform(),
                new PolarTransform()
            ),
            "png",
            Path.of("src", "main", "resources")
        );
//        Point point = new Point(0.3454435, -0.12443);
//        point = new StandardHistogramGenerator().rotate(point, (Math.PI*2)/3);
//        System.out.println(point);
    }
}
