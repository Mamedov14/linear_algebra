package ru.vsu;

public class Matrix {

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

    public static double[][] transposeToMain(double[][] matrix) {
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

    public static double[][] transposeToSide(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
        return matrix;
    }

    public static double[][] getMatrixOfMinors(double[][] mat) {
        mat = getTranspose(mat);
        double[][] matrix;
        double[][] solve = new double[mat.length][mat[0].length];
        for (int n = 0; n < mat.length; n++) {
            for (int m = 0; m < mat[0].length; m++) {
                matrix = arrayOfRange(mat, n, m);
                solve[n][m] = getDeterminant(matrix);
            }
        }

        return solve;
    }

    public static double getDeterminant(double[][] mat) {
        if (mat.length == 2) {
            return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
        } else {
            // Recursive Method
            int total = 0;
            for (int n = 0; n < mat.length; n++) {
                double[][] matrix = arrayOfRange(mat, 0, n);
                if (n % 2 == 0) {
                    total += mat[0][n] * getDeterminant(matrix);
                } else {
                    total -= mat[0][n] * getDeterminant(matrix);
                }
            }
            return total;
        }
    }

    public static double[][] arrayOfRange(double[][] mat, int n, int m) {
        double[][] matrix = new double[mat.length - 1][mat[0].length - 1];
        int row_sub = 0;
        for (int row = 0; row < mat.length; row++) {
            int col_sub = 0;
            if (row != n) {
                for (int col = 0; col < mat[row].length; col++) {
                    if (col != m) {
                        matrix[row - row_sub][col - col_sub] = mat[row][col];
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

    public static double[][] getTranspose(double[][] matrix) {
        double[][] solve = new double[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                solve[col][row] = matrix[row][col];
            }
        }
        return solve;
    }

    public static double[][] getMatrixOfAlgebraicAdditions(double[][] mat) {
        double[][] adj = getMatrixOfMinors(mat);
        int i = 1;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                adj[row][col] *= i;
                i *= -1;
            }
        }
        return adj;
    }

    public static double[][] getInverse(double[][] mat) {
        double determinant = getDeterminant(mat);
        double[][] matrix = getMatrixOfAlgebraicAdditions(mat);
        double[][] solve = new double[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                solve[i][j] = (1. / determinant) * matrix[i][j];
            }
        }
        return solve;
    }

}