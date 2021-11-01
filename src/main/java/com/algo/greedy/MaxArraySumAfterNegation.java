package com.algo.greedy;

import java.util.Arrays;

public class MaxArraySumAfterNegation {
    private static void findMaximumArraySumAfterNegation(int[] arr, int k) {

        int n = arr.length;
        Arrays.sort(arr);
        int i = 0;

        while (k > 0) {
            if (arr[i] >= 0) {
                k = 0;
            } else {
                arr[i] = -arr[i];
                k--;
            }
            i++;
        }

        int sum = Arrays.stream(arr)
                .sum();
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 0, 5, -1, 2};
        findMaximumArraySumAfterNegation(arr, 4);
    }
}
