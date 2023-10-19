package edu.hw2.task2;

public class Rectangle {
    protected final int width;
    protected final int height;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    Rectangle setWidth(int width) {
        return new Rectangle(this.height, width);
    }

    Rectangle setHeight(int height) {
        return new Rectangle(height, this.height);
    }

    double area() {
        return width * height;
    }
}
