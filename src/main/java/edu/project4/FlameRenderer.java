package edu.project4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

public class FlameRenderer {
    private FlameRenderer() {}

    public static void render(FractalFlame flame, String format, Path pathToDirectory) {
        if (!Files.isDirectory(pathToDirectory)) {
            throw new IllegalArgumentException("Invalid path, it is not a directory");
        }
        BufferedImage image = new BufferedImage(flame.getWidth(), flame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Pixel[][] pixels = flame.getHistogram();
        for (Pixel[] pixel : pixels) {
            for (Pixel value : pixel) {
                image.setRGB(value.getX(), value.getY(), parseRGB(value));
            }
        }
        File outputFile = Path.of(
            pathToDirectory.toString(),
            "Fractal_Flame_"
            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss-MM-dd-yyyy"))
            + "."
            + format
        ).toFile();
        try {
            ImageIO.write(image, format, outputFile);
        } catch (IOException e) {
            throw new RuntimeException("Exception during the writing in file");
        }
    }

    private static int parseRGB(int red, int green, int blue) {
        return (red << 16) | (green << 8) | blue;
    }

    private static int parseRGB(Pixel pixel) {
        return (pixel.getRed() << 16) | (pixel.getGreen() << 8) | pixel.getBlue();
    }
}
