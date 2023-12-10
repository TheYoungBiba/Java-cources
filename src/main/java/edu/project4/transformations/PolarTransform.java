package edu.project4.transformations;

import edu.project4.Point;
import edu.project4.Transformation;

public class PolarTransform implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = Math.atan(point.y() / point.x()) / Math.PI;
        double y = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2)) - 1;
        return new Point(x, y);
    }
}