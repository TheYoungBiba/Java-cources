package edu.project4.transformations;

import edu.project4.Point;
import edu.project4.Transformation;

public class SinTransform implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = Math.sin(point.x());
        double y = Math.sin(point.y());
        return new Point(x, y);
    }
}
