package ru.academits.gribukov.shapes.comparators;

import ru.academits.gribukov.shapes.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getArea(), shape2.getArea());
    }
}
