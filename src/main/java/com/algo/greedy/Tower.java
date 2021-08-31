package com.algo.greedy;

import java.util.Arrays;

public class Tower {

    public static void main(String[] args) {
        int[] arr = {1, 15, 10};
        int n = arr.length;
        int k = 6;

        Arrays.sort(arr);
        int small = arr[0] + k;
        int big = arr[n - 1] - k;
        int ans = arr[n - 1] - arr[0];
        int temp = 0;

        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        for (int i = 1; i < n - 1; i++) {
            int subtract = arr[i] - k;
            int addition = arr[i] + k;

            if (subtract >= small || addition <= big)
                continue;

            if (big - subtract <= addition - small)
                small = subtract;
            else
                big = addition;
        }
        System.out.println(Math.min(ans, big - small));

    }
}
