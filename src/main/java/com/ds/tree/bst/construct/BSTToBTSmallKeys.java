package com.ds.tree.bst.construct;

public class BSTToBTSmallKeys {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root;
    static int sum = 0;
    private static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public static void convertToBT(Node node){
        if (node == null) return;
        convertToBT(node.left);
        sum = sum+ node.data;
        node.data   =  sum;
        convertToBT(node.right);
    }

    public static void main(String[] args) {
        root = new Node(9);
        root.left = new Node(6);
        root.right = new Node(15);
        inorder(root);
        System.out.println();
        convertToBT(root);
        inorder(root);
    }
}
