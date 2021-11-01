package com.algo.greedy;

public class BracketBalancing {

    public static void main(String[] args) {
        String brackets = "[]][][";

        int leftPointer = 0;
        int rightPointer = 0;
        int imbalance = 0;
        int swapCount = 0;
        int i = 0;
        int n = brackets.length();
        while (i < n) {
            if (brackets.charAt(i) == '[') {
                leftPointer++;

                if (imbalance > 0) {
                    swapCount += imbalance;
                    imbalance--;
                }

            } else if (brackets.charAt(i) == ']') {
                rightPointer++;
                imbalance = rightPointer - leftPointer;
            }
            i++;
        }
        System.out.println("No. of swaps : " + swapCount);
    }
}
