package com.algo.search;

public class MinElement {

    private static void findMinInSortedRotated(int[] arr){
        int n = arr.length;
        int num = binarySearch(arr,0,n-1,n);
        System.out.println(num);
    }

    private static int binarySearch(int[] arr, int start, int end, int n){
        if(start > end) return -1;

        int mid = start + (end-start)/2;

        if((mid == 0 || arr[mid] <= arr[mid-1]) && (mid == n-1 || arr[mid] <= arr[mid+1])){
            return arr[mid];
        }
        if(mid > 0 && arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]){
            return binarySearch(arr, start, mid-1, n);
        }else
            return binarySearch(arr,mid+1,end,n);
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        findMinInSortedRotated(arr);
    }
}
