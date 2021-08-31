package com.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 18, 12, 20, 15};
        int sum = 35;
        findSubSetWithSum(arr, sum);
    }

    private static void findSubSetWithSum(int[] arr, int sum) {
        findSubsetWithSumUtil(0, sum, arr, 0, new ArrayList<>());
    }

    private static void findSubsetWithSumUtil(int start, int sum, int[] arr, int x, List<Integer> list) {
        if (sum == x) {
            System.out.println("Found ");
            list.stream()
                    .forEach(i -> {System.out.print(i+" ");});
            return;
        }
        if (start == arr.length || x > sum) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            List<Integer> aList = new ArrayList<>(list);
            aList.add(arr[i]);
            findSubsetWithSumUtil(i + 1, sum, arr, x + arr[i], aList);
        }
    }
}
