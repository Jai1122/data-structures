package com.ds.matrix;

public class MatrixRotation {

    private static int[][] rotateMatrixOnceAnticlockwise(int[][] mat){

        int rowStart = 0;
        int rowEnd = mat.length-1;
        int colStart = 0;
        int colEnd = mat[0].length-1;
        int next;
        int curr;

        while(rowStart < rowEnd && colStart < colEnd) {

            next = mat[rowEnd - 1][colStart];

            // Rotate Last Row
            for (int i = colStart; i <= colEnd; i++) {
                curr = mat[rowEnd][i];
                mat[rowEnd][i] = next;
                next = curr;
            }
            rowEnd--;

            //Rotate last coloumn
            for (int i = rowEnd; i >= rowStart; i--) {
                curr = mat[i][colEnd];
                mat[i][colEnd] = next;
                next = curr;
            }
            colEnd--;

            //Rotate First Row
            if (rowStart < rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    curr = mat[rowStart][i];
                    mat[rowStart][i] = next;
                    next = curr;
                }
            }
            rowStart++;

            //Rotate First Column
            if (colStart < colEnd){
                for (int i = rowStart; i <= rowEnd; i++) {
                    curr = mat[i][colStart];
                    mat[i][colStart] = next;
                    next = curr;
                }
            }
            colStart++;
        }

        return mat;
    }

    private static int[][] rotateMatrixOnce(int[][] mat) {

        int rowStart = 0;
        int rowEnd = mat.length;
        int colStart = 0;
        int colEnd = mat[0].length;
        int prev;
        int curr;

        while (rowStart < rowEnd && colStart < colEnd) {
            if (rowStart + 1 == rowEnd || colStart + 1 == colEnd) break;

            //Store first element of next row
            prev = mat[rowStart + 1][colStart];

            //Move Elements of First row
            for (int i = colStart; i < colEnd; i++) {
                curr = mat[rowStart][i];
                mat[rowStart][i] = prev;
                prev = curr;
            }
            rowStart++;

            //Move elements of last column
            for (int i = rowStart; i < rowEnd; i++) {
                curr = mat[i][colEnd - 1];
                mat[i][colEnd - 1] = prev;
                prev = curr;
            }
            colEnd--;

            //Move elements of last row
            if(rowStart < rowEnd){
                for (int i = colEnd-1; i >= colStart; i--) {
                    curr = mat[rowEnd-1][i];
                    mat[rowEnd-1][i]    =   prev;
                    prev = curr;
                }
            }
            rowEnd--;
            
            //Move elements of first column
            if(colStart < colEnd){
                for (int i = rowEnd-1; i >= rowStart ; i--) {
                    curr    =   mat[i][colStart];
                    mat[i][colStart] = prev;
                    prev = curr;
                }
            }
            colStart++;
        }
        return mat;
    }

    private static int[][] rotateClockwiseBy90Deg(int[][] mat){

        mat = transpose(mat);
        int k;

        for (int i = 0; i < mat.length; i++) {
            k = mat.length-1;
            for (int j = 0; j < k; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;
                k--;
            }
        }
        printMatrix(mat);
        return mat;
    }

    private static int[][] transpose(int[][] mat){

        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return mat;
    }

    private static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] rotateMatrixNTimes(int[][] mat, int n){
        while (n > 0){
            mat = rotateMatrixOnce(mat);
            System.out.println("Rotated Matrix "+n--);
            printMatrix(mat);
        }
        return mat;
    }

    private static int[][] rotateMatrixNTimesAntiClockWise(int[][] mat, int n){
        while (n > 0){
            mat = rotateMatrixOnceAnticlockwise(mat);
            System.out.println("Anti Clockwise Rotated Matrix "+n--);
            printMatrix(mat);
        }
        return mat;
    }




    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

       printMatrix(mat);
       rotateMatrixNTimes(mat,2);
       rotateMatrixNTimesAntiClockWise(mat,2);
       rotateClockwiseBy90Deg(mat);
    }
}
