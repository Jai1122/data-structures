package com.algo.search;

public class MissingNumber {

    private static int findMissingNumber(int[] arr) {
        int n = arr.length;

        int sum = n * (n + 1) / 2;

        int arrSum = 0;

        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
        }

        return arrSum - sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6};
        System.out.println(findMissingNumber(a));
    }
}
