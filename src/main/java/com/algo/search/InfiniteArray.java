package com.algo.search;

public class InfiniteArray {

    private static int binarySearch(int[] arr, int start, int end, int num) {

        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == num) {
                return mid;
            }
            if (num < arr[mid]) {
                return binarySearch(arr, start, mid - 1, num);
            } else {
                return binarySearch(arr, mid + 1, end, num);
            }

        }
        return -1;
    }

    private static int findPosition(int[] arr, int k) {
        int start = 0;
        int end = 1;
        int val = arr[0];

        while (val < k) {
            start = end;
            if (2 * end < arr.length - 1) {
                end = 2 * end;
            } else {
                end = arr.length - 1;
            }
            val = arr[end];
        }

        return binarySearch(arr, start, end, k);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        System.out.println(findPosition(arr, 10));
    }
}
