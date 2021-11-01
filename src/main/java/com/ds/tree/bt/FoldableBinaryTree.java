//https://www.geeksforgeeks.org/foldable-binary-trees/
package com.ds.tree.bt;

public class FoldableBinaryTree {
    public static boolean isFoldable(Node root) {
        if (root == null) return true;
        return isFoldable(root.left, root.right);
    }

    public static boolean isFoldable(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return isFoldable(left.left, right.right) && isFoldable(left.right, right.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.right = new Node(5);

        if (isFoldable(root)) System.out.println("Yes");
        else System.out.println("No");
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
