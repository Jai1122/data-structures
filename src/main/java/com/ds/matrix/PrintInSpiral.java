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

    private static void printSpiral(int[][] mat){
        int top = 0;
        int bottom = mat.length-1;
        int left = 0;
        int right = mat[0].length-1;

        while(true){
            if(left > right)
                break;
            for (int i = left; i <= right; i++) {
                System.out.print(mat[top][i]+" ");
            }
            top++;
            if(top>bottom)
                break;

            for (int i = top; i <= bottom; i++) {
                System.out.print(mat[i][right]+" ");
            }
            right--;

            if(left > right)
                break;

            for (int i = right; i >= left; i--) {
                System.out.print(mat[bottom][i]+" ");
            }
            bottom--;

            if(top > bottom)
                break;

            for (int i = bottom; i >= top; i--) {
                System.out.print(mat[i][left]+" ");
            }
            left++;
        }
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(mat);
        System.out.println();
        printSpiral(mat);
    }
}
