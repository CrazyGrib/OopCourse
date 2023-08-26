package ru.academits.gribukov.range.main;

import ru.academits.gribukov.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(12, 32);

        System.out.printf("Заданный диапазон имеет значения:%n from = %f%n to = %f%n", range.getFrom(), range.getTo());

        System.out.println("Теперь давайте зададим свое значение и узнаем длину диапазона:");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вещественное значение from = ");
        range.setFrom(scanner.nextDouble());

        System.out.print("Введите вещественное значение to = ");
        range.setTo(scanner.nextDouble());

        System.out.printf("Получилось диапазон имеет значения:%n from = %f%n to = %f%n", range.getFrom(), range.getTo());
        System.out.printf("Длина диапазона = %f%n", range.getLength());

        System.out.println("И теперь проверим принадлежность числа к диапазону.");
        System.out.print("Введите число для проверки = ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.printf("Число %f принадлежит диапазону %s", number, range);
        } else {
            System.out.printf("Число %f не принадлежит диапазону %s", number, range);
        }

        System.out.println();
        System.out.println();

        Range range1 = new Range(1, 7);
        Range range2 = new Range(3, 7);

        System.out.printf("Имеем 2 диапазона %n%s%n%s%n", range1, range2);

        Range intersection = range1.getIntersection(range2);
        System.out.printf("Результат пересечения диапазонов%n%s%n", intersection);

        Range[] union = range1.getUnion(range2);
        System.out.printf("Результат объединения диапазонов%n%s%n", Arrays.toString(union));

        Range[] difference = range1.getDifference(range2);
        System.out.printf("Результат разности диапазонов%n%s%n", Arrays.toString(difference));
    }
}