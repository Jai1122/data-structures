package com.algo.search;

public class AlmostSorted {

    private static int searchInAlmostSortedArray(int[] arr, int start, int end, int num){
        if(end < start) return -1;

        int mid = start + (end-start)/2;
        if(arr[mid] == num)
            return mid;
        if(mid>start && arr[mid-1] == num)
            return mid-1;
        if(mid<end && arr[mid+1] == num)
            return mid+1;

        if(num < arr[mid])
            return searchInAlmostSortedArray(arr, start, mid-2,num);
        else
            return searchInAlmostSortedArray(arr,mid+2,end, num);
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 10, 4, 40};
        System.out.println(searchInAlmostSortedArray(arr, 0 , arr.length-1, 4));
    }

}
