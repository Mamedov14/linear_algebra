package ru.vsu;

public class Matrix {
    private int n;
    private int m;
    private double[][] elementMatrix;

    public Matrix(int n) {
        this.n = n;
    }

    public Matrix(int n, double[][] elementMatrix) {
        this.n = n;
        this.elementMatrix = elementMatrix;
    }

    public Matrix(int n, int m, double[][] elementMatrix) {
        this.n = n;
        this.m = m;
        this.elementMatrix = elementMatrix;
    }

    public Matrix(double[][] elementMatrix) {
        this.elementMatrix = elementMatrix;
    }

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public Matrix() {
    }

    public static double determinant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        double ans = 0;
        double[][] minor = new double[n - 1][n - 1];
        int l = 1;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == k) {
                        continue;
                    }
                    minor[x][y] = matrix[j][k];
                    ++y;
                    if (y == n - 1) {
                        y = 0;
                        ++x;
                    }
                }
            }
            ans += l * matrix[0][i] * determinant(minor);
            l *= (-1);
        }
        return ans;
    }

    public static double[][] transpose(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

/*

     error :(

*/

    public static double[][] inverseMatrix(double[][] matrix) {
        double[][] transposeMatrix = transpose(matrix);
        double[][] inverseMatrix = new double[matrix.length][matrix.length];
        double inverseDeterminant = 1 / determinant(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                inverseMatrix[i][j] = transposeMatrix[i][j] * inverseDeterminant;
            }
        }
        return inverseMatrix;
    }

}