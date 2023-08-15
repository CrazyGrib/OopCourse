package ru.academits.gribukov.shapes;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    public double getSideLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public double getArea() {
        double sideLength1 = getSideLength(x1, x2, y1, y2);
        double sideLength2 = getSideLength(x1, x3, y1, y3);
        double sideLength3 = getSideLength(x2, x3, y2, y3);

        double triangleSemiPerimeter = getPerimeter() / 2;
        return Math.sqrt(triangleSemiPerimeter * (triangleSemiPerimeter - sideLength1) *
                (triangleSemiPerimeter - sideLength2) * (triangleSemiPerimeter - sideLength3));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, x2, y1, y2) + getSideLength(x1, x3, y1, y3) + getSideLength(x2, x3, y2, y3);
    }

    @Override
    public String toString() {
        return String.format("Triangle. (%f ; %f), (%f ; %f), (%f ; %f)", x1, y1, x2, y2, x3, y3);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) obj;
        return triangle.x1 == x1 && triangle.y1 == y1
                && triangle.x2 == x2 && triangle.y2 == y2
                && triangle.x3 == x3 && triangle.y3 == y3;
    }
}