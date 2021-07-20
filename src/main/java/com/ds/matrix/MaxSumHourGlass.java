package com.ds.matrix;

public class MaxSumHourGlass {
    
    private static int maxSumHourGlass(int[][] mat){
        int R = mat.length;
        int C = mat[0].length;

        if(R < 3 || C < 3){
            System.out.println("Hour Glass not possible");
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                int sum = mat[i][j]+ mat[i][j+1] + mat[i][j+2] +
                            mat[i+1][j+1] +
                            mat[i+2][j] + mat[i+2][j+1] + mat[i+2][j+2];
                maxSum  =   Math.max(sum,maxSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int [][]mat = {{1, 2, 3, 0, 0},
                {0, 0, 0, 0, 0},
                {2, 1, 4, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0}};
        System.out.println(maxSumHourGlass(mat));
    }
}
