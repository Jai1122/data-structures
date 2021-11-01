package com.algo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinDiff {
    public static void main(String[] args) {
        int[] arr = {11, 4, 3, 5, 7, 1};
        int n = arr.length;

        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int minVal  =   0;
        int maxVal = 0;
        for (int i = 0,j=n-1; i < n && j >=0; i++,j--) {
            list.add(arr[i]+arr[j]);
        }
        minVal  = Collections.min(list);
        maxVal  =   Collections.max(list);

        System.out.println("Difference is "+Math.abs(minVal - maxVal));
    }
}
