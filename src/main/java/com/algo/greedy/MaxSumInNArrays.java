package com.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumInNArrays {

    private static void findMaxSumOfIncreasingOrderFromNArrays(int[][] arrays) {

        int n = arrays.length;

        for (int i = 0; i < n; i++) {
            Arrays.sort(arrays[i]);
        }
        int result = 0;
        ArrayList<Integer> list = new ArrayList<>(n);
        outerloop:
        for (int i = n - 1; i >= 0; i--) {
            for (int j = arrays[i].length - 1; j > 0; j--) {
                if (list.isEmpty()) {
                    list.add(arrays[i][j]);
                    break;
                } else {
                    int prev = list.get(list.size() - 1);
                    if (arrays[i][j] < prev) {
                        list.add(arrays[i][j]);
                        break;
                    }
                    if (j == 0)
                        break outerloop;
                }
            }
        }
        if(list.size() != n){
            System.out.println(0);
        }else {
            System.out.println(list.stream()
                    .mapToInt(i -> i)
                    .sum());
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 7, 3, 4},
                {4, 2, 5, 1},
                {9, 5, 1, 8}};
        findMaxSumOfIncreasingOrderFromNArrays(arr);
    }
}
