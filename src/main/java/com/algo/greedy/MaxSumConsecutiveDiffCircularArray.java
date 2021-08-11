package com.algo.greedy;

import java.util.Arrays;

public class MaxSumConsecutiveDiffCircularArray {

    private static void findMaxSumConsecutiveDiffInCircularArray(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        int leftPointer = 0, rightPointer = n-1;

        while(leftPointer < n && rightPointer > 0){
            sum += Math.abs(arr[leftPointer++]-arr[rightPointer--]);
        }
        sum += Math.abs(arr[leftPointer]- arr[rightPointer]);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 1, 8 };
        findMaxSumConsecutiveDiffInCircularArray(arr);
    }
}
