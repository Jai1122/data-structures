package com.ds.matrix;

public class SwapMajorMinorDiagonals {

    private static void swapDiagonals(int mat[][]){
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            int temp = mat[i][i];
            mat[i][i] = mat[i][n-i-1];
            mat[i][n-i-1]= temp;
        }

        printMatrix(mat);
    }

    private static void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}};
        swapDiagonals(matrix);

    }
}
