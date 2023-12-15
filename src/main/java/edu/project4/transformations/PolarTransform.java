package edu.project4.transformations;

import edu.project4.Point;
import edu.project4.Transformation;

public class PolarTransform implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = Math.pow(point.x(), 2) + Math.pow(point.y(), 2);
        double arcTan = Math.atan2(point.y(), point.x());
        double k = Math.sqrt(r);
        return new Point(arcTan / Math.PI, k - 1);
    }
}
