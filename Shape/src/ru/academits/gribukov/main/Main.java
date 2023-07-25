package ru.academits.gribukov.main;

import ru.academits.gribukov.shape.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Shape square1 = new Square(random.nextDouble(20) + 1);
        Shape square2 = new Square(random.nextDouble(20) + 1);
        Shape square3 = new Square(random.nextDouble(20) + 1);
        Shape square4 = new Square(random.nextDouble(20) + 1);

        Shape triangle1 = new Triangle(random.nextDouble(20) + 1, random.nextDouble(20) + 1,
                random.nextDouble(20) + 1, random.nextDouble(20) + 1,
                random.nextDouble(20) + 1, random.nextDouble(20) + 1);
        Shape triangle2 = new Triangle(random.nextDouble(20) + 1, random.nextDouble(20) + 1,
                random.nextDouble(20) + 1, random.nextDouble(20) + 1,
                random.nextDouble(20) + 1, random.nextDouble(20) + 1);
        Shape triangle3 = new Triangle(random.nextDouble(20) + 1, random.nextDouble(20) + 1,
                random.nextDouble(20) + 1, random.nextDouble(20) + 1,
                random.nextDouble(20) + 1, random.nextDouble(20) + 1);
        Shape triangle4 = new Triangle(random.nextDouble(20) + 1, random.nextDouble(20) + 1,
                random.nextDouble(20) + 1, random.nextDouble(20) + 1,
                random.nextDouble(20) + 1, random.nextDouble(20) + 1);

        Shape rectangle1 = new Rectangle(random.nextDouble(20) + 1, random.nextDouble(20) + 1);
        Shape rectangle2 = new Rectangle(random.nextDouble(20) + 1, random.nextDouble(20) + 1);
        Shape rectangle3 = new Rectangle(random.nextDouble(20) + 1, random.nextDouble(20) + 1);
        Shape rectangle4 = new Rectangle(random.nextDouble(20) + 1, random.nextDouble(20) + 1);

        Shape circle1 = new Circle(random.nextDouble(20) + 1);
        Shape circle2 = new Circle(random.nextDouble(20) + 1);
        Shape circle3 = new Circle(random.nextDouble(20) + 1);
        Shape circle4 = new Circle(random.nextDouble(20) + 1);

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
    }
}