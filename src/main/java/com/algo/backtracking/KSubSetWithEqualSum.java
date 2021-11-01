package com.algo.backtracking;

import java.util.Arrays;

public class KSubSetWithEqualSum {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 3, 3};
        int N = arr.length;
        int K = 3;
        if(isKSubsetWithEqualSumPossible(arr,N,K))
            System.out.println("Possible");
        else
            System.out.println("Nahh!!");
    }

    private static boolean isKSubsetWithEqualSumPossible(int[] arr, int N, int K) {

        if (K == 1)
            return true;
        if (N < K)
            return false;
        int sum = Arrays.stream(arr).sum();
        if (sum % K != 0)
            return false;

        int expectedSubSetSum = sum / K;
        int[] subsetSum = new int[K];
        boolean[] taken = new boolean[N];

        subsetSum[0] = arr[N - 1];
        taken[N - 1] = true;
        return isKSubsetWithEqualSumPossibleUtil(arr, subsetSum, taken, expectedSubSetSum,
                K, N, 0, N - 1);
    }

    private static boolean isKSubsetWithEqualSumPossibleUtil(int[] arr, int[] subsetSum, boolean[] taken,
                                                             int expectedSubSetSum, int K, int N, int currentIndex,
                                                             int limitIndex) {
        if (subsetSum[currentIndex] == expectedSubSetSum) {
            if (currentIndex == K - 2) {
                return true;
            }

            return isKSubsetWithEqualSumPossibleUtil(arr, subsetSum, taken, expectedSubSetSum,
                    K, N, currentIndex + 1, N - 1);
        }

        for (int i = limitIndex; i >= 0; i--) {
            if (taken[i])
                continue;
            int temp = subsetSum[currentIndex] + arr[i];
            if (temp <= expectedSubSetSum) {
                taken[i] = true;
                subsetSum[currentIndex] += arr[i];
                boolean next = isKSubsetWithEqualSumPossibleUtil(arr, subsetSum, taken,
                        expectedSubSetSum, K, N, currentIndex, i - 1);
                taken[i] = false;
                subsetSum[currentIndex] -= arr[i];
                if (next)
                    return true;
            }
        }
        return false;
    }
}
