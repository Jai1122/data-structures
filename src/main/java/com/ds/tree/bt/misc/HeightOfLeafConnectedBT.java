package com.ds.tree.bt.misc;

public class HeightOfLeafConnectedBT {

    private static boolean isLeaf(Node node){
        if (node == null) return false;
        return (node.left != null && node.left.right == node
                && node.right != null
                && node.right.left == node);
    }

    public static int getHeight(Node root){
        if (root == null) return 0;
        if (isLeaf(root)) return 1;
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);

        // Given tree contains 3 leaf nodes
        Node L1 = root.left.left.left;
        Node L2 = root.left.right;
        Node L3 = root.right;

        // create circular doubly linked list out of
        // leaf nodes of the tree

        // set next pointer of linked list
        L1.right = L2;
        L2.right = L3;
        L3.right = L1;

        // set prev pointer of linked list
        L3.left = L2;
        L2.left = L1;
        L1.left = L3;

        System.out.println(getHeight(root));
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
