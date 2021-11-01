package com.algo.greedy;

import java.util.Arrays;

public class MaxSumAbsoluteDifference {

    private static void findMaxSumOfAbsoluteDiffForAnyPermutation(int[] arr) {
        int n   = arr.length;
        Arrays.sort(arr);
        int leftPointer = 0, rightPointer = n-1, sum = 0;
        while (leftPointer < n && rightPointer >= 0){
            sum=    sum + Math.abs(arr[leftPointer++]-arr[rightPointer--]);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 8 };
        findMaxSumOfAbsoluteDiffForAnyPermutation(arr);
    }
}
