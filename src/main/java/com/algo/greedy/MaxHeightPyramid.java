package com.algo.greedy;

import java.util.Arrays;

public class MaxHeightPyramid {

    private static int findMaxHeightOfPyramid(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        int prev_width = arr[0];
        int prev_count = 1;
        int curr_width = 0;
        int curr_count = 0;
        int ans =   1;

        for (int i = 1; i < n; i++) {

            curr_width = curr_width + arr[i];
            curr_count = curr_count + 1;

            if(prev_width < curr_width && prev_count < curr_count){
                prev_count  =   curr_count;
                prev_width  =   curr_width;

                curr_count  =   0;
                curr_width  =   0;

                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[]  boxes = {10, 20, 30, 50, 60, 70};
        System.out.println(findMaxHeightOfPyramid(boxes));
    }
}
