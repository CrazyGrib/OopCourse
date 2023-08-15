package ru.academits.gribukov.shapes.main;

import ru.academits.gribukov.shapes.*;

public class Main2 {
    public static void main(String[] args) {
        Shape square1 = new Square(5.5);
        Shape triangle1 = new Triangle(0, 0, 1.1, 1.1, 0.1, 2.2);
        Shape rectangle1 = new Rectangle(4.5, 6.1);
        Shape circle1 = new Circle(3.5);

        Shape square2 = new Square(5.5);
        Shape triangle2 = new Triangle(0, 0, 1.1, 1.1, 0.1, 2.2);
        Shape rectangle2 = new Rectangle(4.5, 6.1);
        Shape circle2 = new Circle(3.5);

        System.out.println(square1);
        System.out.println(triangle1);
        System.out.println(rectangle1);
        System.out.println(circle1);

        System.out.println(square1.hashCode());
        System.out.println(triangle1.hashCode());
        System.out.println(rectangle1.hashCode());
        System.out.println(circle1.hashCode());

        System.out.println(square1.equals(square2));
        System.out.println(triangle1.equals(triangle2));
        System.out.println(rectangle1.equals(rectangle2));
        System.out.println(circle1.equals(circle2));
    }
}