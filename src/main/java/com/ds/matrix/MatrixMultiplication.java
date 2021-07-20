package com.ds.matrix;

public class MatrixMultiplication {

    private static int[][] iterativeMatrixMultiplicationOfSquareMatrices(int[][] mat1, int[][] mat2){

        if(mat1.length!= mat2[0].length){
            System.out.println("Invalid Params");
            return new int[0][0];
        }

        int[][] res = new int[mat1.length][mat1.length];

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1.length; j++) {
                res[i][j] = 0;
                for (int k = 0; k < mat1.length; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return res;
    }

    private static void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int mat1[][] = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 } };

        int mat2[][] = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 } };
        // Initial matrix 1 and matrix 2
        int matrix1[][] = { { 2, 4 }, { 3, 4 } };
        int matrix2[][] = { { 1, 2 }, { 1, 3 } };

        int res[][] = iterativeMatrixMultiplicationOfSquareMatrices(matrix1,matrix2);
        printMatrix(res);
    }
}
