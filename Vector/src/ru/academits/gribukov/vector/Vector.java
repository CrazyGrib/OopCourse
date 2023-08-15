package ru.academits.gribukov.vector;

import java.util.Arrays;

public class Vector {
    private double[] elements;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть <= 0");
        }

        elements = new double[size];
    }

    public Vector(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("Вектор не может быть null.");
        }

        this.elements = Arrays.copyOf(vector.elements, vector.elements.length);
    }

    public Vector(double[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    public Vector(int size, double[] elements) {
        this.elements = Arrays.copyOf(elements, size);
    }

    public double[] getElements() {
        return elements;
    }

    public void setElements(double[] elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        String arrays = Arrays.toString(elements);
        return "{" + arrays.substring(1, arrays.length() - 1) + "}";
    }

    private void bringingTotalSize(Vector vector) {
        if (elements.length > vector.elements.length) {
            vector.elements = Arrays.copyOf(vector.elements, elements.length);
        }

        if (vector.elements.length > elements.length) {
            elements = Arrays.copyOf(elements, vector.elements.length);
        }
    }

    public void add(Vector vector) {
        bringingTotalSize(vector);

        for (int i = 0; i < elements.length; i++) {
            elements[i] += vector.elements[i];
        }
    }

    public void subtract(Vector vector) {
        bringingTotalSize(vector);

        for (int i = 0; i < elements.length; i++) {
            elements[i] -= vector.elements[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < elements.length; i++) {
            elements[i] *= scalar;
        }
    }

    public void revers() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double length = 0;

        for (double element : elements) {
            length += Math.abs(element);
        }

        return Math.sqrt(length);
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

        if (elements.length != vector.elements.length) {
            return false;
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != vector.elements[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        for (double element : elements) {
            hash = prime * hash + Double.hashCode(element);
        }

        return hash;
    }

    public static Vector additionVectors(Vector vector1, Vector vector2) {
        Vector resultAddition = new Vector(vector1);
        resultAddition.add(vector2);
        return resultAddition;
    }

    public static Vector subtractionVectors(Vector vector1, Vector vector2) {
        Vector resultSubtraction = new Vector(vector1);
        resultSubtraction.subtract(vector2);
        return resultSubtraction;
    }

    public static double scalarProductVectors(Vector vector1, Vector vector2) {
        vector1.bringingTotalSize(vector2);
        double result = 0;

        for (int i = 0; i < vector1.elements.length; i++) {
            result += vector1.elements[i] * vector2.elements[i];
        }

        return result;
    }
}
