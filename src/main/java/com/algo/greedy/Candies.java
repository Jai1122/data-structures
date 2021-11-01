package com.algo.greedy;

import java.util.Arrays;

public class Candies {
    public static void main(String[] args) {
        int price[] = {3, 2, 1, 4};
        int N   = price.length;
        int k = 2;
        System.out.println(findMinCost(price,N,k));
        System.out.println(findMaxCost(price,N,k));
    }

    private static int findMinCost(int[] price, int N, int k){
        Arrays.sort(price);
        int minCost = 0;
        for (int i = 0; i < N; i++) {
            minCost += price[i];
            N   =   N-k;
        }
        return minCost;
    }

    private static int findMaxCost(int[] price, int N, int k){
        Arrays.sort(price);
        int maxCost =   0;
        int leftPointer = 0;
        for (int i = N-1; i >=leftPointer ; i--) {
            maxCost += price[i];
            leftPointer = leftPointer+k;
        }

        return maxCost;
    }
}
