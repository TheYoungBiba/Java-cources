package edu.hw2.task2;

public class Rectangle {
    protected final int width;
    protected final int height;

    public Rectangle(int width, int height) {
        if (!isValidInput(width, height)) {
            throw new IllegalArgumentException("Incorrect input. (width < 0 or height < 0)");
        }
        this.width = width;
        this.height = height;
    }

    protected boolean isValidInput(int width, int height) {
        return (width >= 0 && height >= 0);
    }

    protected boolean isValidInput(int side) {
        return side >= 0;
    }

    public Rectangle setWidth(int width) {
        if (!isValidInput(width)) {
            throw new IllegalArgumentException("Incorrect input. (width < 0)");
        }
        return new Rectangle(width, this.height);
    }

    public Rectangle setHeight(int height) {
        if (!isValidInput(height)) {
            throw new IllegalArgumentException("Incorrect input. (height < 0)");
        }
        return new Rectangle(this.width, height);
    }

    public double area() {
        return width * height;
    }
}
