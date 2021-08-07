package com.algo.search;

import java.util.Stack;

public class NearestSmallNumber {

    private static void findPrevSmallNumbers(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i])
                stack.pop();
            if (stack.isEmpty())
                System.out.print("_,");
            else
                System.out.print(stack.peek() + ", ");

            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 2, 5};
        findPrevSmallNumbers(arr);
    }

}
