package com.algo.search;

public class JumpSearch {

    private static int search(int[] arr, int num){
        int n = arr.length;

        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;
        while(arr[Math.min(step,n)-1]<num){
            prev = step;
            step+=(int) Math.floor(Math.sqrt(n));
            if(prev >= n) return -1;
        }

        while(arr[prev] < num){
            prev++;
            if(prev == Math.min(step,n))
                return -1;
        }

        if(arr[prev] == num)
            return prev;

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        System.out.println(search(arr,x));
    }
}
