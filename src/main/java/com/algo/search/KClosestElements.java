package com.algo.search;

import java.util.Arrays;

public class KClosestElements {

    private static void findKClosestElements(int[] arr, int k, int x, int n) {
        Arrays.sort(arr);
        int l = binarySearch(arr, 0, n - 1, x);
        int r = l + 1;
        int count = 0;

        if (arr[l] == x) l--;

        while (l >= 0 && r < n && count < k) {
            if (x - arr[l] < arr[r] - x) {
                System.out.println(arr[l--]);
            } else {
                System.out.println(arr[r++]);
            }
            count++;
        }
        while (count < k && l >= 0) {
            System.out.print(arr[l--] + " ");
            count++;
        }
        while (count < k && r < n) {
            System.out.print(arr[r++] + " ");
            count++;
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int num) {

        if (arr[end] <= num) // x is greater than all
            return end;
        if (arr[start] > num)  // x is smaller than all
            return start;

        if (start > end) return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] <= num && arr[mid + 1] > num)
            return mid;

        if (arr[mid] > num) {
            return binarySearch(arr, start, mid - 1, num);
        } else
            return binarySearch(arr, mid + 1, end, num);
    }

    public static void main(String[] args) {
        int[] arr = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
        int k = 4;
        int x = 35;
        findKClosestElements(arr, k, x, arr.length);
    }
}
