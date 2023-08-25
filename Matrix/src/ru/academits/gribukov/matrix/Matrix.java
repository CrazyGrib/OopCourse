package ru.academits.gribukov.matrix;

import ru.academits.gribukov.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        matrix = new Vector[n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        this.matrix = Arrays.copyOf(matrix.matrix, matrix.matrix.length);
    }

    public Matrix(double[][] matrix) {
        this.matrix = new Vector[matrix.length];
        int maxSize = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            maxSize = Math.max(matrix[i].length, maxSize);
        }

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i] = new Vector(maxSize, matrix[i]);
        }
    }

    public Matrix(Vector[] matrix) {
        this.matrix = new Vector[matrix.length];
        int maxSize = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            maxSize = Math.max(matrix[i].getSize(), maxSize);
        }

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i] = new Vector(maxSize, matrix[i].getElements());
        }
    }

    @Override
    public String toString() {
        String vectors = Arrays.toString(this.matrix);
        return "{" + vectors.substring(1, vectors.length() - 1) + "}";
    }

    public int getSizeN() {
        return matrix.length;
    }

    public int getSizeM() {
        return matrix[0].getSize();
    }

    public Vector getVectorN(int index) {
        return matrix[index];
    }

    public void setVectorN(int index, Vector vector) {
        matrix[index] = new Vector(getSizeM(), vector.getElements());
    }

    public Vector getVectorM(int index) {
        double[] elements = new double[getSizeN()];

        for (int i = 0; i < getSizeN(); i++) {
            elements[i] = matrix[i].getElement(index);
        }

        return new Vector(elements);
    }

    public void transposition() {
        Vector[] vectors = new Vector[getSizeM()];

        for (int i = 0; i < getSizeM(); i++) {
            vectors[i] = getVectorM(i);
        }

        matrix = vectors;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector vector : matrix) {
            vector.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (getSizeM() != getSizeN()) {
            throw new NullPointerException("Оперделитель можно вычислить только для квадратной матрицы.");
        }

        if (getSizeM() == 1) {
            return matrix[0].getElement(0);
        }

        if (getSizeM() == 2) {
            return matrix[0].getElement(0) * matrix[1].getElement(1) - matrix[0].getElement(1) * matrix[1].getElement(0);
        }

        return getDeterminant(matrix, 1);
    }

    private static double getDeterminant(Vector[] matrix, double coefficient) {
        double determinant = 0;

        if (matrix.length <= 1) {
            return coefficient * matrix[0].getElement(0);
        } else {
            Vector[] subMatrix = new Vector[matrix.length - 1];

            for (int i = 0; i < subMatrix.length; i++) {
                subMatrix[i] = new Vector(matrix[0].getSize() - 1);
            }

            for (int i = 0; i < matrix[0].getSize(); i++) {
                for (int j = 1; j < matrix.length; j++) {
                    for (int k = 0; k < matrix[0].getSize(); k++) {
                        if (k < i) {
                            subMatrix[j - 1].setElement(k, matrix[j].getElement(k));
                        } else if (k > i) {
                            subMatrix[j - 1].setElement(k - 1, matrix[j].getElement(k));
                        }
                    }
                }

                double minorDeterminant = Math.pow(-1, i) * matrix[0].getElement(i) * coefficient;
                determinant += getDeterminant(subMatrix, minorDeterminant);
            }
        }

        return determinant;
    }

    private static double getDeterminant(Vector[] matrix, Vector vector) {
        double determinant = 0;
        Vector[] subMatrix = new Vector[matrix.length - 1];

        for (int i = 0; i < subMatrix.length; i++) {
            subMatrix[i] = new Vector(matrix[0].getSize() - 1);
        }

        for (int i = 0; i < matrix[0].getSize(); i++) {
            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].getSize(); k++) {
                    if (k < i) {
                        subMatrix[j - 1].setElement(k, matrix[j].getElement(k));
                    } else if (k > i) {
                        subMatrix[j - 1].setElement(k - 1, matrix[j].getElement(k));
                    }
                }
            }

            double minorDeterminant = Math.pow(-1, i) * matrix[0].getElement(i);
            determinant += getDeterminant(subMatrix, minorDeterminant);
        }


        return determinant;
    }
}
