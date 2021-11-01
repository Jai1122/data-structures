package com.ds.tree.bt.construct;

public class SpecialBinaryTreeFromInorder {
    public static void main(String[] args) {
        int[] in = {1, 5, 10, 40, 30,
                15, 28, 20};
        Node root = null;
        inorder(constructTree(root, in, 0, in.length - 1));
    }

    public static Node constructTree(Node node, int[] in, int start, int end) {
        if (start > end) return null;

        int largestIndex = findLargestIndex(in, start, end);
        node = new Node(in[largestIndex]);

        node.left = constructTree(node.left, in, start, largestIndex - 1);
        node.right = constructTree(node.right, in, largestIndex + 1, end);

        return node;
    }

    public static int findLargestIndex(int[] arr, int start, int end) {
        int max = 0;
        int i = start;

        for (; start <= end; start++) {
            if (arr[start] > max) {
                max = arr[start];
                i = start;
            }
        }
        return i;
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
