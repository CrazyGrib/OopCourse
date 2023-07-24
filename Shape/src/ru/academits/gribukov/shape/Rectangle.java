package ru.academits.gribukov.shape;

public class Rectangle implements Shape{

    private final double height;
    private final double width;

    public Rectangle(double length, double width) {
        this.height = length;
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return (height + width) * 2;
    }
}
