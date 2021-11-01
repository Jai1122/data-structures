package com.ds.tree.bt;

//https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/
public class PostOrderTraversalFromPreOrderTraversal {
    public static void main(String[] args) {
        int[] pre = {40, 30, 32, 35, 80, 90, 100, 120};
        printPostOrder(pre);
    }

    public static void printPostOrder(int[] pre) {
        int pivot = 0;
        for (int i = 1; i < pre.length; i++) {
            if (pre[0] <= pre[i]) {
                pivot = i;
                break;
            }
        }

        for (int i = pivot - 1; i > 0; i--) {
            System.out.print(pre[i] + " ");
        }
        for (int i = pre.length - 1; i >= pivot; i--) {
            System.out.print(pre[i] + " ");
        }
        System.out.print(pre[0]);
    }
}
