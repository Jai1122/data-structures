package com.algo.search;

public class ClosestPair {

    private static void findClosestPair(int arr1[], int arr2[], int x){
        int start = 0;
        int n  = arr1.length;
        int end = arr2.length-1;
        int val1 = 0;
        int val2 = 0;
        int minDiff = Integer.MAX_VALUE;

        while(start < n && end >=0){
            if((Math.abs(arr1[start]+arr2[end] - x ) < minDiff)){
                minDiff = Math.abs(arr1[start]+arr2[end] - x );
                val1 = arr1[start];
                val2 = arr2[end];
            }

            if(arr1[start]+arr2[end] <= x){
                start++;
            }else {
                end--;
            }
        }
        System.out.println("Closest Pair is "+val1+", "+val2);
    }

    public static void main(String[] args) {
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int x = 38;

        findClosestPair(ar1,ar2,x);
    }
}
