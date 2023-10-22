package edu.hw2.task2;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    @Override
    public Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }
}
