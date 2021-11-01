package com.ds.tree.bt;
//https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/

public class SymmetricTree {
    public static boolean isSymmetric(Node root) {
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null) return true;

        if (left.data == right.data)
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);


        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        if (isSymmetric(root)) System.out.println("Yes");
        else System.out.println("No");
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
