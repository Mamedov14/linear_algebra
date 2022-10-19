package ru.vsu;

public class Main {
    public static void main(String[] args) {
       /* Matrix matrix = new Matrix(4, new double[][]{
                {1, 2, 5, 1},
                {3, 4, 6, 2},
                {3, 5, 8, 4},
                {6, 7, 8, 9}}
        );*/
       /* double[][] matrix = new double[][]{
                {1, 2, 5, 1},
                {3, 4, 6, 2},
                {3, 5, 8, 4},
                {6, 7, 8, 9}
        };
        System.out.println(Matrix.determinant(matrix));*/
        double integral = Integral.integralRectangle(0, 2, x -> Math.sin(x) * Math.pow(x, 2));
        System.out.println(integral);
        integral = Integral.integralTrapezoid(0, 2, x -> Math.sin(x) * Math.pow(x, 2));
        System.out.println(integral);

        double[][] matrix = new double[][]{
                {1, 2, 5},
                {3, 4, 6},
                {3, 5, 8},
        };
       /* Matrix.transpose(matrix);
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }*/
        System.out.println();
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        double[][] inverseMatrix = Matrix.inverseMatrix(matrix);
        for (int i = 0; i < inverseMatrix.length; i++) {
            for (int j = 0; j < inverseMatrix.length; j++) {
                System.out.print(inverseMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}