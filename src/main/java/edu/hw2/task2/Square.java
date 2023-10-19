package edu.hw2.task2;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    Rectangle setWidth(int width) {
        return new Rectangle(this.height, width);
    }

    @Override
    Rectangle setHeight(int height) {
        return new Rectangle(height, this.width);
    }
}
