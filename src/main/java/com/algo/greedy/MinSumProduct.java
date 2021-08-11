package com.algo.greedy;

public class MinSumProduct {

    private static void findMinSumProductWithModifications(int[] firstArray, int[] secondArray, int k){

        if(firstArray.length!= secondArray.length) throw new IllegalArgumentException("Array size must be same");

        int n = firstArray.length;

        //Find index of largest number (abs) in second array
        int bigNum  =   Integer.MIN_VALUE;
        int bigIndex = -1;
        boolean isBigNegative   =   false;
        for (int i = 0; i < n; i++) {
            if(Math.abs(secondArray[i]) > bigNum){
                bigNum  =   secondArray[i];
                bigIndex    =   i;
                isBigNegative   =   secondArray[i]<0?true:false;
            }
        }

        if(isBigNegative){
            firstArray[bigIndex] =  firstArray[bigIndex] + (k * 2) ;
        }else {
            firstArray[bigIndex] =  firstArray[bigIndex] - (k * 2);
        }

        //find product sum
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (firstArray[i]*secondArray[i]);
        }

        System.out.println("Minimum sum is "+sum);
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 4, 5, 4};
        int b[]  = {3, 4, 2, 3, 2};
        findMinSumProductWithModifications(a,b,3);
    }
}
