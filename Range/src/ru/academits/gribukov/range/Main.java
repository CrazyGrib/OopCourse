package ru.academits.gribukov.range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(5, 12);
        /*
        System.out.printf("Заданный диапазон имеет значения:%n from = %f%n to = %f%n", range.getFrom(), range.getTo());

        System.out.println("Теперь задвайте зададим свое значение и узнаем длину диапазона:");

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

         */

        Range range2 = new Range(13, 15);

        Range[] rangeArray = range.getUnion(range2);
        if (rangeArray.length == 2) {
            System.out.printf("Получилось 2 диапазона%n" +
                            "Первый диапозон имеет значения:%n from = %f%n to = %f.%n" +
                            "Второй диапозон имеет значения:%n from = %f%n to = %f.%n",
                    rangeArray[0].getFrom(), rangeArray[0].getTo(),
                    rangeArray[1].getFrom(), rangeArray[1].getTo());
        } else {
            System.out.printf("Получился 1 диапазона%n" +
                            "Диапозон имеет значения:%n from = %f%n to = %f",
                    rangeArray[0].getFrom(), rangeArray[0].getTo());
        }
    }
}