package com.ds.matrix;

import java.util.Arrays;
import java.util.Collections;

public class RowAndColumnSorts {
    
    private static void sortRowsAndColumns(Integer[][] mat){
        mat = sortByRows(mat,true);
        mat = transpose(mat);
        mat = sortByRows(mat,false);
        mat = transpose(mat);
        printMatrix(mat);
    }

    private static Integer[][] sortByRows(Integer[][] mat, boolean asc){
        if(asc) {
            for (int i = 0; i < mat.length; i++) {
                Arrays.sort(mat[i]);
            }
        }else{
            for (int i = 0; i < mat.length; i++) {
                Arrays.sort(mat[i], Collections.reverseOrder());
            }
        }

        return mat;
    }

    private static Integer[][] transpose(Integer[][] mat){

        for (int i = 0; i < mat.length; i++) {
            for (int j = i+1; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        return mat;
    }

    private static void printMatrix(Integer[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer mat[][] = {{3, 2, 1},
                {9, 8, 7},
                {6, 5, 4}};
        sortRowsAndColumns(mat);
    }
}