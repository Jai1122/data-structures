package com.algo.search;

public class BinarySearch {

    private static int iterativeSearch(int[] arr, int start, int end, int num){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid] == num){
                return mid;
            }
            if(arr[mid]> num){
                end=mid-1;
            }else if(arr[mid]<num){
                start = mid+1;
            }
        }

        return -1;
    }

    private static int recursiveSearch(int[] arr, int start, int end, int num){
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if(arr[mid] == num) return mid;
        if(num<arr[mid]) return recursiveSearch(arr, start, mid-1,num);
        if(num>arr[mid]) return recursiveSearch(arr, mid+1, end,num);
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        System.out.println(recursiveSearch(arr,0,arr.length,x));
    }
}
