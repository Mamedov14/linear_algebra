package ru.vsu;

public class Main {
    public static void main(String[] args) {

        double[][] matrix = new double[][]{
                {1, 2, 5},
                {3, 4, 6},
                {3, 5, 8},
        };

        // OUTPUT MATRIX
        System.out.println("______________OUTPUT MATRIX______________");
        Matrix.getMatrixOutOut(matrix);

        // TRANSPOSE MATRIX
        System.out.println("______________TRANSPOSE MATRIX______________");
        double[][] transpose = Matrix.getTranspose(matrix);
        Matrix.getMatrixOutOut(transpose);

        // DETERMINANT MATRIX
        System.out.println("______________DETERMINANT MATRIX______________");
        double determinant = Matrix.getDeterminant(matrix);
        System.out.println(determinant);

        // INVERSE MATRIX
        System.out.println("______________INVERSE MATRIX______________");
        double[][] inverse = Matrix.getInverse(matrix);
        Matrix.getMatrixOutOut(inverse);

        // INTEGRAL
        System.out.println("______________INTEGRAL SIN(x)______________");
        System.out.printf("Integral = %.6f", Integral.integralTrapezoid(-5, 8, Math::sin));
    }
}