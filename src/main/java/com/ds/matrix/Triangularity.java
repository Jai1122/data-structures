package com.ds.matrix;

public class Triangularity {

    private static boolean isLowerTriangular(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(i<j && mat[i][j]!=0)
                    return false;
            }
        }

        return true;
    }

    private static boolean isUpperTriangle(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(i>j && mat[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 2, 3, 4 },
                        { 0, 4, 5, 6 },
                        { 0, 0, 2, 7 },
                        { 0, 0, 0, 6 } };
        System.out.println(isLowerTriangular(mat));
        System.out.println(isUpperTriangle(mat));
    }
}
