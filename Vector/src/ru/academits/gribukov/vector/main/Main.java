package ru.academits.gribukov.vector.main;

import ru.academits.gribukov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3);
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4, 5, 6, 7});
        Vector vector3 = new Vector(vector2);
        Vector vector4 = new Vector(3, new double[]{2, 3, 4, 5, 6, 7});
        Vector vector5 = new Vector(9, new double[]{1, 2, 3, 4});

        System.out.println("v1: " + vector1);
        System.out.println("v2: " + vector2);
        System.out.println("v3: " + vector3);
        System.out.println("v4: " + vector4);
        System.out.println("v5: " + vector5);

        System.out.println("v2 ~ v3 " + vector2.equals(vector3));
        System.out.println("v1 ~ v4 " + vector1.equals(vector4));

        System.out.println("v2.size = " + vector2.getSize());

        vector4.add(vector3);
        System.out.println("v4 + v3 = " + vector4);

        vector3.subtract(vector4);
        System.out.println("v3 - v4 = " + vector3);

        vector2.multiplyByScalar(3);
        System.out.println("v2 * 3 = " + vector2);

        vector2.reverse();
        System.out.println("-v2: " + vector2);

        System.out.println("v3.length = " + vector3.getLength());

        System.out.println("v5: " + vector5);
        vector5.setElement(7, 7);
        System.out.println("v5: " + vector5);
        System.out.println("v5.7: " + vector5.getElement(7));

        Vector vector6 = Vector.getSum(vector2, vector5);
        System.out.println("Static: v2 + v5 = v6:" + vector6);

        Vector vector7 = Vector.getDifference(vector2, vector5);
        System.out.println("Static: v2 - v5 = v7:" + vector7);

        System.out.println("Static: v6 * v7 = " + Vector.getScalarProduct(vector6, vector7));
    }
}