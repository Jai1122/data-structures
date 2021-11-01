package com.ds.matrix;

public class SymmetricMatrix {

    private static int minFlipsToSymmetric(int[][] mat){

        int flip = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < i; j++) {
                if(mat[i][j] != mat[j][i])
                    ++flip;
            }
        }

        return flip;
    }

    public static void main(String[] args) {
        int mat[][] = {{ 0, 0, 1 },
                { 1, 1, 1 },
                { 1, 0, 0 }};

        System.out.println(minFlipsToSymmetric(mat));
    }
}
