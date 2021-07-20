package com.ds.matrix;

public class UpperAndLowerTriangles {

    private static void printTriangle(int[][] mat, int row, int col){

        System.out.println("Lower Triangle");

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(i < j){
                    System.out.print(0+" ");
                }else {
                    System.out.print(mat[i][j]+" ");
                }
            }
            System.out.println();
        }

        System.out.println("Upper Triangle");

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(i > j){
                    System.out.print(0+" ");
                }else {
                    System.out.print(mat[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int row = 3, col = 3;
        printTriangle(matrix,row,col);
    }
}
