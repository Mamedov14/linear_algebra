package ru.vsu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeterminantMatrixTest {
    @Test
    public void determinantMatrixTest1() {
        /*Matrix matrix = new Matrix(4, new double[][]{
                {1, 2, 5, 1},
                {3, 4, 6, 2},
                {3, 5, 8, 4},
                {6, 7, 8, 9}}
        );*/
        double[][] matrix = new double[][]{
                {1, 2, 5, 1},
                {3, 4, 6, 2},
                {3, 5, 8, 4},
                {6, 7, 8, 9}
        };
        assertEquals(Matrix.getDeterminant(matrix), 29);
    }

    @Test
    public void determinantMatrixTest2() {
        /*Matrix matrix = new Matrix(4, new double[][]{
                {1, 2, 5},
                {3, 4, 6},
                {3, 5, 8}}
        );*/
        double[][] matrix = new double[][]{
                {1, 2, 5},
                {3, 4, 6},
                {3, 5, 8},
        };
        assertEquals(Matrix.getDeterminant(matrix), 5);
    }
}