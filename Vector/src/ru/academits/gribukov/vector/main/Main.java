package ru.academits.gribukov.vector.main;

import ru.academits.gribukov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3);
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4, 5, 6, 7});
        Vector vector3 = new Vector(vector2);
        Vector vector4 = new Vector(3, new double[]{2, 3, 4, 5, 6, 7});
        Vector vector5 = new Vector(9, new double[]{1, 2, 3, 4});

        System.out.println("1: " + vector1);
        System.out.println("2: " + vector2);
        System.out.println("3: " + vector3);
        System.out.println("4: " + vector4);
        System.out.println("5: " + vector5);

        System.out.println("2~3 " + vector2.equals(vector3));
        System.out.println("1~4 " + vector1.equals(vector4));

        System.out.println("2.size = " + vector2.getSize());

        vector4.add(vector3);
        System.out.println("4 + 3 = " + vector4);

        vector3.subtract(vector4);
        System.out.println("3 - 4 = " + vector3);

        vector2.multiplyByScalar(3);
        System.out.println("2 * \"3\" = " + vector2);

        vector2.revers();
        System.out.println("-2: " + vector2);

        System.out.println("4.length = " + vector4.getLength());

        System.out.println("5: " + vector5);
        vector5.setElement(7, 7);
        System.out.println("5: " + vector5);
        System.out.println("5.7: " + vector5.getElement(7));

        Vector vector6 = Vector.additionVectors(vector2, vector5);
        System.out.println("Static: 2 + 5 = " + vector6);

        Vector vector7 = Vector.subtractionVectors(vector2, vector5);
        System.out.println("Static: 2 - 5 = " + vector7);

        System.out.println("Static: 6 * 7 = " + Vector.scalarProductVectors(vector6, vector7));
    }
}