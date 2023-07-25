package ru.academits.gribukov.shape;

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
        double maxX = Math.max(x1, Math.max(x2, x3));
        double minX = Math.min(x1, Math.min(x2, x3));
        return maxX- minX;
    }

    @Override
    public double getHeight() {
        double maxY = Math.max(y1, Math.max(y2, y3));
        double minY = Math.min(y1, Math.min(y2, y3));
        return maxY- minY;
    }

    @Override
    public double getArea() {
        double lineALength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double lineBLength = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double lineCLength = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));

        double triangleSemiPerimeter = (lineALength + lineBLength + lineCLength) / 2;
        return Math.sqrt(triangleSemiPerimeter * (triangleSemiPerimeter - lineALength) *
                (triangleSemiPerimeter - lineBLength) * (triangleSemiPerimeter - lineCLength));
    }

    @Override
    public double getPerimeter() {
        double lineALength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double lineBLength = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double lineCLength = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));

        return (lineALength + lineBLength + lineCLength) / 2;
    }
}