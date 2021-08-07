package com.algo.search;

public class Peak {

    private static void findPeak(int[] arr) {
        int midPeak = findPeakUtil(arr, 0, arr.length - 1, arr.length);
        System.out.println(arr[midPeak]);
    }

    private static int findPeakUtil(int[] arr, int low, int high, int n) {

        int mid = low + (high - low) / 2;

        if ((mid == 0 || arr[mid - 1] <= arr[mid])
                && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;
        else if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeakUtil(arr, low, (mid - 1), n);
        else
            return findPeakUtil(arr, (mid + 1), high, n);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findPeak(arr);
    }
}
