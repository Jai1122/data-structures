package com.algo.search;

import java.util.Arrays;

public class Pair {

    private static void findPairWithDiff(int[] arr, int diff){
        Arrays.sort(arr);
        int n = arr.length;
        if(arr[n-1] < diff) return;
        int start = 0;
        int end = n;

        for (int i = 0; i < arr.length; i++) {
            int pair = binarySearch(arr,i+1,n,arr[i]+diff);
            if( pair != -1){
                System.out.println("Found "+arr[i]+" , "+arr[pair]);
                return;
            }
        }
        System.out.println("No such element");
    }

    private static int binarySearch(int[] arr, int start, int end, int num){
        if(start >= end) return -1;
        int mid = start + (end-start)/2;
        if(arr[mid] == num)
            return mid;
        if(arr[mid] > num){
            binarySearch(arr, start,mid-1,num);
        }else if(arr[mid]<num){
            binarySearch(arr, mid+1,end,num);
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 8, 30, 40, 100};
        findPairWithDiff(arr,60);
    }
}
