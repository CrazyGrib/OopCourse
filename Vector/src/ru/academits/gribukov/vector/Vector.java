package ru.academits.gribukov.vector;

import java.util.Arrays;

public class Vector {
    private double[] elements;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть <= 0. Указанный размер равен: " + size);
        }

        elements = new double[size];
    }

    public Vector(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("Вектор не может быть null.");
        }

        elements = Arrays.copyOf(vector.elements, vector.elements.length);
    }

    public Vector(double[] elements) {
        if (elements == null) {
            throw new NullPointerException("Вектор не может быть null.");
        }

        if (elements.length == 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть = 0. Указанный размер равен: " + elements.length);
        }

        this.elements = Arrays.copyOf(elements, elements.length);
    }

    public Vector(int size, double[] elements) {
        if (elements == null) {
            throw new NullPointerException("Вектор не может быть null.");
        }

        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть <= 0. Указанный размер равен: " + size);
        }

        if (elements.length == 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть = 0. Указанный размер равен: " + elements.length);
        }

        this.elements = Arrays.copyOf(elements, size);
    }

    public int getSize() {
        return elements.length;
    }

    @Override
    public String toString() {
        int length = elements.length - 1;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (int i = 0; ; i++) {
            stringBuilder.append(elements[i]);

            if (i == length) {
                return stringBuilder.append('}').toString();
            }

            stringBuilder.append(", ");
        }
    }

    private void bringToTotalSize(Vector vector) {
        if (vector.elements.length > elements.length) {
            elements = Arrays.copyOf(elements, vector.elements.length);
        }
    }

    public void add(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("Нельзя добавить null к вектору.");
        }

        bringToTotalSize(vector);

        for (int i = 0; i < elements.length; i++) {
            if (i >= vector.elements.length) {
                break;
            }

            elements[i] += vector.elements[i];
        }
    }

    public void subtract(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("Нельзя вычесть null из вектора.");
        }

        bringToTotalSize(vector);

        for (int i = 0; i < elements.length; i++) {
            if (i >= vector.elements.length) {
                break;
            }

            elements[i] -= vector.elements[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < elements.length; i++) {
            elements[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double coordinateSum = 0;

        for (double element : elements) {
            coordinateSum += Math.pow(element, 2);
        }

        return Math.sqrt(coordinateSum);
    }

    public double getElement(int index) {
        return elements[index];
    }

    public void setElement(int index, double element) {
        elements[index] = element;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) obj;
        return Arrays.equals(elements, vector.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }


    public static Vector getSum(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new NullPointerException("Вектор не может быть null.");
        }

        Vector sum = new Vector(vector1);
        sum.add(vector2);
        return sum;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new NullPointerException("Вектор не может быть null.");
        }

        Vector difference = new Vector(vector1);
        difference.subtract(vector2);
        return difference;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        if (vector1 == null || vector2 == null) {
            throw new NullPointerException("Вектор не может быть null.");
        }

        int minSize = Math.min(vector1.elements.length, vector2.elements.length);
        double result = 0;

        for (int i = 0; i < minSize; i++) {
            result += vector1.elements[i] * vector2.elements[i];
        }

        return result;
    }
}
