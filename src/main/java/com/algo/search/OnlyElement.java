package com.algo.search;

public class OnlyElement {

    private static void findElementThatOccursOnlyOnce(int[] arr){
        int n = arr.length;
        for (int i = 0; i < arr.length; i = i+2) {
            if(i == arr.length-1){
                System.out.println(arr[i]);
                return;
            }
            if(arr[i] != arr[i+1]){
                System.out.println(arr[i]);
                return;
            }
        }
        System.out.println("No such element");
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8};
        findElementThatOccursOnlyOnce(arr);
    }
}
