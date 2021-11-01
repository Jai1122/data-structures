package com.ds.tree.bst.checkandsearch;

import java.util.Stack;

public class CheckIfPreOrderIsBST {
    public static void main(String[] args) {
        int[] pre = {2, 4, 1};
        isBST(pre);
    }

    public static boolean isBST(int[] pre){
        int n = pre.length;
        Stack<Integer> stack    =   new Stack<>();
        int root  = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(pre[i] < root) return false;
            while (!stack.isEmpty() && stack.peek() < pre[i]){
                root= stack.pop();
            }
            stack.push(pre[i]);
        }

        return true;
    }

}
