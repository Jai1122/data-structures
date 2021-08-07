package com.algo.search;

public class CommonElements {

    private static void findCommonElements(int[] arr1, int[] arr2, int[] arr3){
        for (int i = 0; i < arr1.length; i++) {
            int arr2Index = binarySearch(arr2,0,arr2.length,arr1[i]);
            if(arr2Index != -1){
                int arr3Index = binarySearch(arr2,0,arr2.length,arr1[i]);
                if(arr3Index != -1){
                    System.out.print(arr1[i]+" ,");
                }
            }
        }
    }

    private static int binarySearch(int arr[], int start, int end, int num){
        if(start > end) return -1;

        int mid = start + (end - start)/2;

        if(arr[mid] == num) return mid;
        if(arr[mid] > num) return binarySearch(arr, start, mid-1, num);
        else return binarySearch(arr, mid+1, end, num);
    }

    public static void main(String[] args) {
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        findCommonElements(ar1, ar2, ar3);
    }
}
