package ru.academits.gribukov.shape;

public class Rectangle implements Shape {

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

    @Override
    public String toString() {
        return "Rectangle. height = " + height + ", width = " + width;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(height);
        hash = prime * hash + Double.hashCode(width);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        if (obj.hashCode() != this.hashCode()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) obj;
        return rectangle.height == this.height && rectangle.width == this.width;
    }
}
