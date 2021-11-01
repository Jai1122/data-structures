package com.algo.greedy;

import java.util.Arrays;

// All positives and no zero    -> Product of all
// All negatives and no zero    -> If array size is even product of all
//                              -> If array size is odd product of all elements except largest one
// Positives with zero          -> Product all except zero
// Negatives with zero          -> If array size is 2 then output is zero
//                              -> Product all negatives if negatives count is even
//                              -> Product all negatives except the maximum one if negatives count is odd
//  Both positives and negatives -> Product of all postives and two smallest negatives
public class MaxProductSubSet {

    private static int findMaxProductSubset(int[] arr) {

        int numPositives = 0;
        int numNegatives = 0;
        int numZeros = 0;
        int positiveProduct = 1;
        int negativeProduct = 1;
        int indexShiftToPositive = -1;
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                numZeros++;
                continue;
            }
            if (arr[i] < 0) {
                numNegatives++;
                negativeProduct *= arr[i];
            }

            if (i > 0 && arr[i - 1] < 0 && arr[i] > 0) {
                indexShiftToPositive = i - 1;
            }

            if (arr[i] > 0) {
                numPositives++;
                positiveProduct *= arr[i];
            }
        }

        //All Positives
        if (numPositives == n)
            return positiveProduct;

        //All Zeros
        if (numZeros == n) {
            return 0;
        }

        //All negatives
        if (numNegatives == n) {
            //Even
            if (numNegatives % 2 == 0) {
                return negativeProduct;
            } else {
                //Odd
                return negativeProduct / arr[indexShiftToPositive];
            }
        }
        //All negatives with zero
        if (numZeros != 0 && numZeros + numNegatives == n) {
            if (numNegatives % 2 == 0) {
                return negativeProduct;
            } else {
                if (numNegatives == 1) return arr[0];
                return negativeProduct / arr[numNegatives - 1];
            }
        }
        //Positive and negative without zero
        if (numZeros == 0) {
            if (numNegatives % 2 == 0) {
                return positiveProduct * negativeProduct;
            } else {
                return positiveProduct * (negativeProduct / arr[indexShiftToPositive]);
            }
        }

        //Positive and negative with zero
        if (numNegatives % 2 == 0) {
            return positiveProduct * negativeProduct;
        } else {
            return positiveProduct * (negativeProduct / arr[numNegatives - 1]);
        }

    }

    public static void main(String[] args) {
        int[] a = {-1, -1, -2, 4, 3, 0};
        System.out.println(findMaxProductSubset(a));
    }

}
