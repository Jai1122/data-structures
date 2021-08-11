package com.algo.greedy;

public class MinProductSubsetInArray {

    private static int findMinProductSubSetInArray(int[] arr) {

        int numNegs = 0;
        int numZeros = 0;
        int negMax = Integer.MIN_VALUE;
        int posMin = Integer.MAX_VALUE;
        int nonZeroProducts = 1;
        int n = arr.length;

        if(n == 1) return arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                numZeros++;
                continue;
            }

            if (arr[i] < 0) {
                numNegs++;
                negMax = Math.max(negMax, arr[i]);
            }

            if (arr[i] > 0 && arr[i] < posMin) {
                posMin = arr[i];
            }

            nonZeroProducts *= arr[i];
        }

        if (numZeros == n || (numNegs == 0 && numZeros > 0)) {
            return 0;
        }

        if (numNegs == 0) {
            return posMin;
        }

        if (numNegs % 2 == 0 && numNegs != 0) {
            nonZeroProducts = nonZeroProducts / negMax;
        }
        return nonZeroProducts;
    }

    public static void main(String[] args) {
        int a[] = { -1, -1, -2, 4, 3 };
        System.out.println(findMinProductSubSetInArray(a));
    }

}
