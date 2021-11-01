package com.algo.search;

import java.util.Arrays;

public class TwoElementSum {
    private static void twoElementsSumClosestToZero(int[] arr){

        Arrays.sort(arr);
        int minSum = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;

        for (int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i-1]) > Math.abs(arr[i])){
                int temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
            }
        }

        printArray(arr);
        for (int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i-1]+arr[i]) <= minSum){
                minSum = Math.abs(arr[i-1]+arr[i]);
                l = i-1;
                r = i;
            }
        }

        System.out.println(arr[l]+" , "+arr[r]);
    }

    private static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 60, -10, 70, -80, 85};
        twoElementsSumClosestToZero(arr);
    }
}
