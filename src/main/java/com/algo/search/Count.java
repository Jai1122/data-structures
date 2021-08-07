package com.algo.search;

public class Count {
    private static void countOnes(int[] arr){
        System.out.println(lastOccurenceOfOne(arr,0,arr.length)+1);

    }

    private static int lastOccurenceOfOne(int[] arr, int start, int end){
        if(start > end) return -1;

        int mid = start + (end-start)/2;
        if(arr[arr.length-1] == 1) return arr.length-1;
        if(arr[0] == 0) return -1;
        if(mid+1 != arr.length && arr[mid] == 1 && arr[mid+1] != 1){
            return mid;
        }

        if(mid+1 != arr.length && arr[mid+1] == 1){
            return lastOccurenceOfOne(arr,mid+1,end);
        }
        else{
            return lastOccurenceOfOne(arr,start,mid-1);
        }

    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 0, 0, 0, 0};
        System.out.println(lastOccurenceOfOne(arr,0,arr.length-1)+1);
    }

}
