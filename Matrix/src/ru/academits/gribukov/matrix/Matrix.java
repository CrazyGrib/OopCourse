package ru.academits.gribukov.matrix;

import ru.academits.gribukov.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Размерность матрицы не может быть <= 0. Указанный размер равен: " + n + ":" + m);
        }

        matrix = new Vector[n];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        if (matrix == null) {
            throw new NullPointerException("Матрица не может быть null.");
        }

        this.matrix = Arrays.copyOf(matrix.matrix, matrix.matrix.length);
    }

    public Matrix(double[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Матрица не может быть null.");
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Размерность матрицы не может быть = 0. Указанный размер равен: " + matrix.length);
        }

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
        if (matrix == null) {
            throw new NullPointerException("Матрица не может быть null.");
        }

        if (matrix.length == 0) {
            throw new IllegalArgumentException("Размерность матрицы не может быть = 0. Указанный размер равен: " + matrix.length);
        }

        this.matrix = new Vector[matrix.length];
        int maxSize = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            maxSize = Math.max(matrix[i].getSize(), maxSize);
        }

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i] = new Vector(maxSize);

            for (int j = 0; j < maxSize; j++) {
                if (j < matrix[i].getSize()) {
                    this.matrix[i].setElement(j, matrix[i].getElement(j));
                } else {
                    break;
                }
            }
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
        if (index < 0 || index > getSizeN()) {
            throw new IllegalArgumentException("Выход за рамки матрицы. Размер матрицы: " + getSizeN() + ":" + getSizeM());
        }

        return matrix[index];
    }

    public void setVectorN(int index, Vector vector) {
        if (index < 0 || index > getSizeN()) {
            throw new IllegalArgumentException("Выход за рамки матрицы. Размер матрицы: " + getSizeN() + ":" + getSizeM());
        }

        if (vector == null) {
            throw new NullPointerException("Добавляемый вектор не может быть null.");
        }

        matrix[index] = new Vector(getSizeM());

        for (int i = 0; i < getSizeM(); i++) {
            if (i < vector.getSize()) {
                matrix[index].setElement(i, vector.getElement(i));
            } else {
                break;
            }
        }
    }

    public Vector getVectorM(int index) {
        if (index < 0 || index > getSizeM()) {
            throw new IllegalArgumentException("Выход за рамки матрицы. Размер матрицы: " + getSizeN() + ":" + getSizeM());
        }

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
            throw new IllegalArgumentException("Оперделитель можно вычислить только для квадратной матрицы.");
        }

        if (getSizeM() == 1) {
            return matrix[0].getElement(0);
        }

        return getDeterminant(this);
    }

    private static double getDeterminant(Matrix matrix) {
        double determinant = 0;

        if (matrix.getSizeN() == 2) {
            Vector vector1 = matrix.getVectorN(0);
            Vector vector2 = matrix.getVectorN(1);
            return vector1.getElement(0) * vector2.getElement(1)
                    - vector1.getElement(1) * vector2.getElement(0);
        } else {
            int koeff;
            Vector vector = matrix.getVectorN(0);

            for (int i = 0; i < matrix.getSizeN(); i++) {
                if (i % 2 == 1) {
                    koeff = -1;
                } else {
                    koeff = 1;
                }

                determinant += koeff * vector.getElement(i) * getDeterminant(getMinor(matrix, i));
            }
        }

        return determinant;
    }

    private static Matrix getMinor(Matrix matrix, int column) {
        int minorMatrixSize = matrix.getSizeN() - 1;
        double[][] minor = new double[minorMatrixSize][minorMatrixSize];
        int dI = 0;

        for (int i = 0; i <= minorMatrixSize; i++) {
            int dJ = 0;

            for (int j = 0; j <= minorMatrixSize; j++) {
                if (i == 0) {
                    dI = 1;
                    break;
                } else {
                    if (j == column) {
                        dJ = 1;
                    } else {
                        minor[i - dI][j - dJ] = matrix.getVectorN(i).getElement(j);
                    }
                }
            }
        }

        return new Matrix(minor);
    }

    public Vector multiplyByVectorM(Vector vector) {
        if (vector == null) {
            throw new NullPointerException("Вектор не должен быть null.");
        }

        if (vector.getSize() != getSizeM()) {
            throw new IllegalArgumentException("Число столбцов в матрице должно совпадать с числом строк в векторе. " +
                    "Размер переданного вектора: " + vector.getSize() + ". Размер матрицы: " + getSizeN() + ":" + getSizeM());
        }

        Vector resultVector = new Vector(getSizeM());

        for (int i = 0; i < getSizeM(); i++) {
            resultVector.setElement(i, Vector.getScalarProduct(matrix[i], vector));
        }

        return resultVector;
    }
}