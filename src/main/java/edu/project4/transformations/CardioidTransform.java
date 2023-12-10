package edu.project4.transformations;

import edu.project4.Point;
import edu.project4.Transformation;

public class CardioidTransform implements Transformation {
    @Override
    public Point apply(Point point) {
        double sqrtOfQuadXY = Math.sqrt(Math.pow(point.x(), 2) + Math.pow(point.y(), 2));
        double x = sqrtOfQuadXY * Math.sin(sqrtOfQuadXY * Math.atan(point.y() / point.x()));
        double y = -sqrtOfQuadXY * Math.cos(sqrtOfQuadXY * Math.atan(point.y() / point.x()));
        return new Point(x, y);
    }
}
