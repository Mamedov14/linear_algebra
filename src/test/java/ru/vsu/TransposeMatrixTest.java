package ru.vsu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransposeMatrixTest {

    @Test
    public void transposeMatrixTest1() {
        double[][] matrix = new double[][]{
                {1, 2, 5},
                {3, 4, 6},
                {3, 5, 8},
        };
        double[][] transposeMatrix = new double[][]{
                {1, 3, 3},
                {2, 4, 5},
                {5, 6, 8},
        };
        assertEquals(Matrix.transpose(matrix), transposeMatrix);
    }

}