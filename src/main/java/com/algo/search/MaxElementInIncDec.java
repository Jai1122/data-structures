package com.algo.search;

public class MaxElementInIncDec {

    private static int findMaxElementInIncDecArray(int[] arr){

        int start = 0;
        int end = arr.length;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                return arr[mid];
            }
            if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1]){
                end = mid-1;
            }else if(arr[mid] < arr[mid+1] && arr[mid] > arr[mid-1]){
                start = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 30, 40, 50, 60, 70, 23, 20};
        System.out.println(findMaxElementInIncDecArray(arr));
    }
}
