package edu.project4.transformations;

import edu.project4.Point;
import edu.project4.Transformation;

public class CardioidTransform implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.pow(point.x(), 2) + Math.pow(point.y(), 2);
        double k = Math.sqrt(r);
        double arcTan = Math.atan2(point.y(), point.x());
        return new Point(k * Math.sin(k * arcTan), -k * Math.cos(k * arcTan));
    }
}
