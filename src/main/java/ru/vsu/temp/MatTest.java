package ru.vsu.temp;

public class MatTest {

    private int n;
    private int m;
    private double[][] matrix;
    private double[] vector;

    public MatTest(double[][] matrix) {
        this.matrix = matrix;
    }

    public double getDeterminant(MatTest matTest) {
        if (matTest.matrix.length == 2) {
            return (matTest.matrix[0][0] * matTest.matrix[1][1]) - (matTest.matrix[0][1] * matTest.matrix[1][0]);
        } else {
            int total = 0;
            for (int n = 0; n < matTest.matrix.length; n++) {
                matTest.matrix = arrayOfRange(matTest);
                if (n % 2 == 0) {
                    total += matTest.matrix[0][n] * getDeterminant(matTest);
                } else {
                    total -= matTest.matrix[0][n] * getDeterminant(matTest);
                }
            }
            return total;
        }
    }

    public static double[][] arrayOfRange(MatTest matTest) {
        double[][] matrix = new double[matTest.matrix.length - 1][matTest.matrix[0].length - 1];
        int row_sub = 0;
        for (int row = 0; row < matTest.matrix.length; row++) {
            int col_sub = 0;
            if (row != matTest.n) {
                for (int col = 0; col < matTest.matrix[row].length; col++) {
                    if (col != matTest.m) {
                        matrix[row - row_sub][col - col_sub] = matTest.matrix[row][col];
                    } else {
                        col_sub = 1;
                    }
                }
            } else {
                row_sub = 1;
            }
        }
        return matrix;
    }
}
