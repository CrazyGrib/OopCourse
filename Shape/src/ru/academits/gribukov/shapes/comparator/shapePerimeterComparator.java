package ru.academits.gribukov.shapes.comparator;

import ru.academits.gribukov.shapes.Shape;

import java.util.Comparator;

public class shapePerimeterComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }
}
