package com.ds.matrix;

import java.util.ArrayList;
import java.util.List;

public class SquaresOfMatrixDiagonals {
    
    private static void diagonalSquare(int[][] mat){

        int n = mat.length;
        List<Integer> list1 = new ArrayList<>(n);
        List<Integer> list2 = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j)
                    list1.add(mat[i][j]*mat[i][j]);
                if(i+j == n-1)
                    list2.add(mat[i][j]*mat[i][j]);
            }
        }
        list1.stream().forEach(System.out::print);
        System.out.println();
        list2.stream().forEach(System.out::print);
    }
    
    public static void main(String[] args) {
        int mat[][] = { { 2, 5, 7 },
                { 3, 7, 2 },
                { 5, 6, 9 } };
        diagonalSquare(mat);
    }
}
