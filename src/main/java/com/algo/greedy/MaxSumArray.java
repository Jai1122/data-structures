package com.algo.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumArray {
    private static void findMaximumSumArray(int[] arr) {
        Arrays.sort(arr);
        System.out.println(IntStream.range(0, arr.length)
                .map(i -> arr[i] * i)
                .sum());
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 1};
        findMaximumSumArray(arr);
    }
}
