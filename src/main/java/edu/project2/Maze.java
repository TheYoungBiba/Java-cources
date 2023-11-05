package edu.project2;

//public final class Maze {
//    private int width;
//    private int height;
//    private int[][] preRenderedGrid;
//    private int startCol;
//    private int exitCol;
//
//    private boolean isValidCol(int col) {
//        return col < width && col >= 0;
//    }
//
//    public Maze(Generator algorithm, int height, int width, int startCol, int exitCol) {
//        this.height = height;
//        this.width = width;
//        int[][] preRenderedGrid = algorithm.generateMaze(height, width);
//        if (!isValidCol(startCol)) {
//            throw new IllegalArgumentException("Incorrect start point");
//        }
//        if (!isValidCol(exitCol)) {
//            throw new IllegalArgumentException("Incorrect exit point");
//        }
//        this.startCol = startCol;
//        this.exitCol = exitCol;
//        preRenderedGrid[0][startCol * 2 + 1] = 0;
//        preRenderedGrid[preRenderedGrid.length - 1][exitCol * 2 + 1] = 0;
//        this.preRenderedGrid = preRenderedGrid;
//    }
//
//    public int getStartCol() {
//        return startCol;
//    }
//
//    public int getExitCol() {
//        return exitCol;
//    }
//
//    public int[][] getPreRenderedGrid() {
//        return preRenderedGrid;
//    }
//}

public final class Maze {
    private int width;
    private int height;
    private int[][] preRenderedGrid;
    private Coordinate startPoint;
    private Coordinate exitPoint;

//  Указание координат начала и конца идет с учетом внешних и внутренних стенок
    public Maze(Generator algorithm, int height, int width) {
        this.height = height;
        this.width = width;
        int[][] preRenderedGrid = algorithm.generateMaze(height, width);
        this.preRenderedGrid = preRenderedGrid;
    }

    private boolean isValidPoint(Coordinate point) {
        if (point.x() >= preRenderedGrid.length || point.x() < 0
            || point.y() >= preRenderedGrid[0].length || point.y() < 0) {
            return false;
        }
        if (preRenderedGrid[point.x()][point.y()] == 1 && (point.x() > 0 && point.x() < preRenderedGrid.length - 1
            && point.y() > 0 && point.y() < preRenderedGrid[0].length - 1)) {
            return false;
        }
        if ((point.x() == 0 && point.y() == 0)
            || (point.x() == preRenderedGrid.length - 1 && point.y() == 0)
            || (point.y() == preRenderedGrid.length - 1 && point.x() == 0)
            || (point.x() == point.y() && point.x() == preRenderedGrid.length - 1)) {
            return false;
        }
        return true;
    }

    private boolean isNearEmptyness(Coordinate point) {
        final int[] xShift = {1, 0, -1, 0};
        final int[] yShift = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int shiftedX = point.x() + xShift[i];
            int shiftedY = point.y() + yShift[i];
            if (shiftedX < preRenderedGrid.length && shiftedX >= 0
                && shiftedY < preRenderedGrid[0].length && shiftedY >= 0) {
                if (preRenderedGrid[shiftedX][shiftedY] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setStartPoint(Coordinate startPoint) {
        if (isValidPoint(startPoint)) {
            if (preRenderedGrid[startPoint.x()][startPoint.y()] == 1 && isNearEmptyness(startPoint)) {
                preRenderedGrid[startPoint.x()][startPoint.y()] = 2;
                this.startPoint = startPoint;
            } else if (preRenderedGrid[startPoint.x()][startPoint.y()] == 0) {
                preRenderedGrid[startPoint.x()][startPoint.y()] = 2;
                this.startPoint = startPoint;
            } else {
                throw new IllegalArgumentException("Illegal start point.");
            }
        } else {
            throw new IllegalArgumentException("Illegal start point.");
        }
    }

    public void setExitPoint(Coordinate exitPoint) {
        if (isValidPoint(exitPoint)) {
            if (preRenderedGrid[exitPoint.x()][exitPoint.y()] == 1 && isNearEmptyness(exitPoint)) {
                preRenderedGrid[exitPoint.x()][exitPoint.y()] = 2;
                this.exitPoint = exitPoint;
            } else if (preRenderedGrid[exitPoint.x()][exitPoint.y()] == 0) {
                preRenderedGrid[exitPoint.x()][exitPoint.y()] = 2;
                this.exitPoint = exitPoint;
            } else {
                throw new IllegalArgumentException("Illegal exit point.");
            }
        } else {
            throw new IllegalArgumentException("Illegal exit point.");
        }
    }

    public void setPoints(Coordinate startPoint, Coordinate exitPoint) {
        setStartPoint(startPoint);
        setExitPoint(exitPoint);
    }

    public Coordinate getStartPoint() {
        return startPoint;
    }

    public Coordinate getExitPoint() {
        return exitPoint;
    }

    public int[][] getPreRenderedGrid() {
        return preRenderedGrid;
    }
}
