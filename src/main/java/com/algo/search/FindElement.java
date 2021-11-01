package com.algo.search;

public class FindElement {

    private static int findPivot(int[] arr, int low, int high) {
        if (high < low) return -1;
        if (high == low) return low;

        int mid = low + (high - low) / 2;

        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return mid - 1;
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);

        return findPivot(arr, mid + 1, high);
    }

    private static int binarySearch(int[] arr, int start, int end, int num) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == num)
                return mid;
            if (arr[mid] > num)
                return binarySearch(arr, 0, mid - 1, num);
            if (arr[mid] > num)
                return binarySearch(arr, mid + 1, end, num);
        }
        return -1;
    }

    private static int findElementInSortedRotatedArray(int[] arr, int num) {
        int pivot = findPivot(arr, 0, arr.length - 1);
        if (pivot == -1)
            return binarySearch(arr, 0, arr.length, num);

        if (arr[pivot] == num)
            return pivot;
        if (arr[0] <= num)
            return binarySearch(arr, 0, pivot - 1, num);

        return binarySearch(arr, pivot + 1, arr.length - 1, num);
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(findElementInSortedRotatedArray(arr, 3));
    }
}
