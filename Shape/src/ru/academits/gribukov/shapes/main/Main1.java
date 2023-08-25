package ru.academits.gribukov.shapes.main;

import ru.academits.gribukov.shapes.comparators.ShapeAreaComparator;
import ru.academits.gribukov.shapes.*;
import ru.academits.gribukov.shapes.comparators.ShapePerimeterComparator;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        Shape square1 = new Square(2);
        Shape square2 = new Square(5);
        Shape square3 = new Square(10);
        Shape square4 = new Square(15);

        Shape triangle1 = new Triangle(0, 0, 1.1, 1.1, 0.1, 2.2);
        Shape triangle2 = new Triangle(-1, -1, 5, 1, 0, 3);
        Shape triangle3 = new Triangle(3, 9, 0, 6, 4, 2);
        Shape triangle4 = new Triangle(1, 2, 3, -1, 5, 5);

        Shape rectangle1 = new Rectangle(2, 5);
        Shape rectangle2 = new Rectangle(4, 4);
        Shape rectangle3 = new Rectangle(6, 10);
        Shape rectangle4 = new Rectangle(15, 3);

        Shape circle1 = new Circle(2);
        Shape circle2 = new Circle(5);
        Shape circle3 = new Circle(10);
        Shape circle4 = new Circle(15);

        Shape[] shapes = {
                square1, triangle1, rectangle1, circle1,
                square2, triangle2, rectangle2, circle2,
                square3, triangle3, rectangle3, circle3,
                square4, triangle4, rectangle4, circle4
        };

        System.out.println("Квадраты:");
        System.out.println(square1.getHeight() + ", " + square1.getWidth() + ", " +
                square1.getArea() + ", " + square1.getPerimeter());
        System.out.println(square2.getHeight() + ", " + square2.getWidth() + ", " +
                square2.getArea() + ", " + square2.getPerimeter());
        System.out.println(square3.getHeight() + ", " + square3.getWidth() + ", " +
                square3.getArea() + ", " + square3.getPerimeter());
        System.out.println(square4.getHeight() + ", " + square4.getWidth() + ", " +
                square4.getArea() + ", " + square4.getPerimeter());
        System.out.println();

        System.out.println("Треугольники:");
        System.out.println(triangle1.getHeight() + ", " + triangle1.getWidth() + ", " +
                triangle1.getArea() + ", " + triangle1.getPerimeter());
        System.out.println(triangle2.getHeight() + ", " + triangle2.getWidth() + ", " +
                triangle2.getArea() + ", " + triangle2.getPerimeter());
        System.out.println(triangle3.getHeight() + ", " + triangle3.getWidth() + ", " +
                triangle3.getArea() + ", " + triangle3.getPerimeter());
        System.out.println(triangle4.getHeight() + ", " + triangle4.getWidth() + ", " +
                triangle4.getArea() + ", " + triangle4.getPerimeter());
        System.out.println();

        System.out.println("Прямоугольники:");
        System.out.println(rectangle1.getHeight() + ", " + rectangle1.getWidth() + ", " +
                rectangle1.getArea() + ", " + rectangle1.getPerimeter());
        System.out.println(rectangle2.getHeight() + ", " + rectangle2.getWidth() + ", " +
                rectangle2.getArea() + ", " + rectangle2.getPerimeter());
        System.out.println(rectangle3.getHeight() + ", " + rectangle3.getWidth() + ", " +
                rectangle3.getArea() + ", " + rectangle3.getPerimeter());
        System.out.println(rectangle4.getHeight() + ", " + rectangle4.getWidth() + ", " +
                rectangle4.getArea() + ", " + rectangle4.getPerimeter());
        System.out.println();

        System.out.println("Окружности:");
        System.out.println(circle1.getHeight() + ", " + circle1.getWidth() + ", " +
                circle1.getArea() + ", " + circle1.getPerimeter());
        System.out.println(circle2.getHeight() + ", " + circle2.getWidth() + ", " +
                circle2.getArea() + ", " + circle2.getPerimeter());
        System.out.println(circle3.getHeight() + ", " + circle3.getWidth() + ", " +
                circle3.getArea() + ", " + circle3.getPerimeter());
        System.out.println(circle4.getHeight() + ", " + circle4.getWidth() + ", " +
                circle4.getArea() + ", " + circle4.getPerimeter());
        System.out.println();

        Shape shapeWithMaxArea = getShapeWithMaxArea(shapes);
        if (shapeWithMaxArea == null) {
            System.out.print("Фигуры с самой большой площадью нет.");
        } else {
            System.out.printf("Фигура с самой большой площадью %s%nПлощадь равна: %f", shapeWithMaxArea, shapeWithMaxArea.getArea());
        }
        System.out.println();

        Shape shapeWithSecondMaxPerimeter = getShapeWithSecondMaxPerimeter(shapes);
        if (shapeWithSecondMaxPerimeter == null) {
            System.out.print("Фигуры со вторым по величине периметром нет.");
        } else {
            System.out.printf("Фигура со вторым по величине периметром %s%nПериметр равен: %f", shapeWithSecondMaxPerimeter, shapeWithSecondMaxPerimeter.getPerimeter());
        }
    }

    public static Shape getShapeWithMaxArea(Shape... shapes) {
        if (shapes.length == 0) {
            return null;
        }

        Shape[] shapesSortedByArea = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesSortedByArea, new ShapeAreaComparator());
        return shapesSortedByArea[0];
    }

    public static Shape getShapeWithSecondMaxPerimeter(Shape... shapes) {
        if (shapes.length == 0) {
            return null;
        }

        if (shapes.length == 1) {
            return null;
        }

        Shape[] shapesSortedByPerimeter = Arrays.copyOf(shapes, shapes.length);
        Arrays.sort(shapesSortedByPerimeter, new ShapePerimeterComparator());
        return shapesSortedByPerimeter[1];
    }
}