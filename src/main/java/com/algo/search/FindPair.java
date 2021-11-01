package com.algo.search;

public class FindPair {

    private static void findPairClosestTo(int[] arr, int x){

        int val1 = 0;
        int val2 = 0;
        int start = 0;
        int end = arr.length-1;
        int minDiff = Integer.MAX_VALUE;

        while(start < end){
            if(Math.abs(arr[start]+arr[end]-x) < minDiff){
                val1 = arr[start];
                val2 = arr[end];
                minDiff = Math.abs(arr[start]+arr[end]-x);
            }
            if(arr[start]+arr[end] < x){
                start++;
            }else{
                end--;
            }
        }
        System.out.println("Closest Pair is "+val1+", "+val2);
    }

    public static void main(String[] args) {
        int arr[] =  {10, 22, 28, 29, 30, 40}, x = 54;
        findPairClosestTo(arr,x);
    }

}
