package ru.academits.gribukov.matrix.main;

import ru.academits.gribukov.matrix.Matrix;
import ru.academits.gribukov.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 3);

        double[][] arrays = new double[][]{
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 3, 4},
                {2, 3, 4, 5, 6, 7}
        };
        Matrix matrix2 = new Matrix(arrays);

        Matrix matrix3 = new Matrix(new Vector[]{
                new Vector(5, new double[]{1, 2, 3, 4}),
                new Vector(3),
                new Vector(new double[]{1, 2, 3, 4, 5, 6, 7}),
                new Vector(new double[]{2.0, 3.0, 4.0})
        });

        Matrix matrix4 = new Matrix(matrix3);

        System.out.println("m1 - " + matrix1);
        System.out.println("m2 - " + matrix2);
        System.out.println("m3 - " + matrix3);
        System.out.println("m4 - " + matrix4);
        System.out.println();

        System.out.printf("Размер матрицы m4: N = %d, M = %d%n", matrix4.getSizeN(), matrix4.getSizeM());
        System.out.println("Вектор-строка индекса 1 - " + matrix4.getVectorN(1));
        Vector vector = new Vector(new double[]{12, 23, 34});
        System.out.println("В m4 в индекс 1 вставляем вектор - " + vector);
        matrix4.setVectorN(1, vector);
        System.out.printf("Получилась матрица:%n%s%n", matrix4);
        System.out.println("Вектор-столбец индекса 1 - " + matrix4.getVectorM(1));
        System.out.println();

        matrix4.transposition();
        System.out.printf("Транспониировали матрицу:%n%s%n", matrix4);

        matrix4.multiplyByScalar(3);
        System.out.printf("Умножили матрицу на скаляр 3:%n%s%n", matrix4);

        System.out.println();

        arrays = new double[][]{
                {1, 0, -2},
                {3, 2, 1},
                {1, 2, -2}
        };
        Matrix matrix5 = new Matrix(arrays);

        System.out.println("m5 - " + matrix5);
        System.out.printf("Определитель матрицы m5:%n%f%n", matrix5.getDeterminant());
    }
}