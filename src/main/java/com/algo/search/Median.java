package com.algo.search;

public class Median {

    private static int getMedian(int[] arr1, int[] arr2){

        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1+n2;
        int i1 = 0;
        int i2 = 0;
        int[] arr = new int[n];
        int i   =   0;
        while(i1 < n1 && i2 < n2){
            if(arr1[i1] <= arr2[i2]){
                arr[i++] = arr1[i1++];
            }else{
                arr[i++] = arr2[i2++];
            }
        }

        while(i1 != n1){
            arr[i++] = arr1[i1++];
        }

        while(i2 != n2){
            arr[i++] = arr2[i2++];
        }

        return n%2!=0? arr[(n-1)/2]: (arr[n/2]+arr[n/2 -1])/2;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 6 };
        int[] arr2 = { 4, 6, 8, 10 };
        System.out.println(getMedian(arr1,arr2));
    }
}
