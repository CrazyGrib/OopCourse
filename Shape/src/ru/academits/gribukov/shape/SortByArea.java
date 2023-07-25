package ru.academits.gribukov.shape;

import java.util.Comparator;

public class SortByArea implements Comparator<Shape> {
    public int compare(Shape firstShape, Shape secondShape) {
        double epsilon = 1.0e-10;

        if (firstShape.getArea() - secondShape.getArea() >= -epsilon) return -1;
        else if (Math.abs(firstShape.getArea() - secondShape.getArea()) <= epsilon) return 0;
        else return 1;
    }
}
