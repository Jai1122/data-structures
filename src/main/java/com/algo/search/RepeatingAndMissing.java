package com.algo.search;

public class RepeatingAndMissing {

    private static void findRepeatingAndMissingNumber(int[] arr) {

        int i;
        System.out.print("Repeating Value : ");
        for (i = 0; i < arr.length; i++) {
            int absVal = Math.abs(arr[i]);
            if (arr[absVal - 1] > 0) {
                arr[absVal - 1] = -arr[absVal - 1];
            } else {
                System.out.print(absVal);
            }
        }
        System.out.println();
        System.out.print("Missing Value : ");
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > 0) {
                System.out.print(j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 5, 5, 6, 2};
        findRepeatingAndMissingNumber(arr);
    }
}
