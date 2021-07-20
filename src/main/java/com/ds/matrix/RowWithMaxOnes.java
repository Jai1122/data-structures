package com.ds.matrix;

public class RowWithMaxOnes {

    public static void main(String[] args)
    {
        int mat[][] = { { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } };
        System.out.println("Index of row with maximum 1s is "
                + rowWithMax1s(mat));
    }

    private static int rowWithMax1s(int[][] mat){

        int maxOne  =   Integer.MAX_VALUE;
        int maxRow = -1;
        for (int i = 0; i < mat.length; i++) {
            int one = findOne(mat[i],0,mat[i].length-1);
            if(maxOne > one && one != -1){
                maxOne = one;
                maxRow = i;
            }
        }
        return maxRow;
    }

    private static int findOne(int[] arr, int low, int high){
        if(high >= low){
            int mid = low + (high - low) / 2;
            if((mid == 0 || arr[mid-1]== 0) && arr[mid] == 1)
                return mid;
            else if(arr[mid] == 0)
                return findOne(arr,mid+1,high);
            else
                return findOne(arr, low, mid-1);
        }
        return -1;
    }
}
