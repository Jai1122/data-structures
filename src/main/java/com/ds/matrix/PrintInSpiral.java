package com.ds.matrix;

public class PrintInSpiral {

    private static void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void printSpiralInReverse(int[][] mat){
        int rowStart = 0;
        int rowEnd = mat.length-1;
        int colStart = 0;
        int colEnd = mat.length-1;

        while(rowStart < rowEnd && colStart < colEnd){

            //Print first column
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(mat[i][colStart]+", ");
            }
            colStart++;

            //Print last row
            for (int i = colStart; i <= colEnd; i++) {
                System.out.print(mat[rowEnd][i]+", ");
            }
            rowEnd--;

            //Print last column
            for (int i = rowEnd; i >= rowStart ; i--) {
                System.out.print(mat[i][colEnd]+", ");
            }
            colEnd--;

            //Print first row
            for (int i = colEnd; i >= colStart ; i--) {
                System.out.print(mat[rowStart][i]+", ");
            }
            rowStart++;
        }
    }

    private static void printSpiral(int[][] mat){
        int rowStart = 0;
        int rowEnd = mat.length-1;
        int colStart = 0;
        int colEnd = mat.length-1;

        while(rowStart < rowEnd && colStart < colEnd){

            //Print First Row
            for (int i = colStart; i <= colEnd; i++) {
                System.out.print(mat[rowStart][i]+", ");
            }
            rowStart++;

            //Print last column
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(mat[i][colEnd]+", ");
            }
            colEnd--;

            //Print last row
            for (int i = colEnd; i >= colStart ; i--) {
                System.out.print(mat[rowEnd][i]+", ");
            }
            rowEnd--;

            //Print first column
            for (int i = rowEnd; i >= rowStart ; i--) {
                System.out.print(mat[i][colStart]+", ");
            }
            colStart++;
        }
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(mat);
        System.out.println();
        //printSpiral(mat);
        System.out.println("Spriral in Reverse");
        printSpiralInReverse(mat);
    }
}
