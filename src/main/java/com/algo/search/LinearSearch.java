package com.algo.search;

public class LinearSearch {

    private static int linearSearchOnePointer(int[] arr, int num){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }

    private static int linearSearchTwoPointer(int[] arr, int num){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            if(arr[left] == num){
                return left;
            }

            if(arr[right] == num){
                return right;
            }
            left++;
            right--;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        System.out.println(linearSearchOnePointer(arr,x));
        System.out.println(linearSearchTwoPointer(arr,x));
    }
}
