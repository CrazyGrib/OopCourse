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
            System.out.printf("Число %f принадлежит диапазону (%f;%f)", number, range.getFrom(), range.getTo());
        } else {
            System.out.printf("Число %f не принадлежит диапазону (%f;%f)", number, range.getFrom(), range.getTo());
        }

        System.out.println();
        System.out.println();

        Range range1 = new Range(12, 24);
        Range range2 = new Range(13, 16);

        System.out.printf("Имеем 2 диапозона %n" + range1 + "%n" + range2 + "%n");

        Range intersectionRange = range1.getIntersection(range2);
        System.out.printf("Результат пересечения диапозонов%n" + intersectionRange + "%n");

        Range[] rangeUnionArray = range1.getUnion(range2);
        System.out.printf("Результат объединения диапозонов%n" + Arrays.toString(rangeUnionArray) + "%n");


        Range[] rangeDifferenceArray = range1.getDifference(range2);
        System.out.printf("Результат разности диапозонов%n" + Arrays.toString(rangeDifferenceArray) + "%n");
    }
}