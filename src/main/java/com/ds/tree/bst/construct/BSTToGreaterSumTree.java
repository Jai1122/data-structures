package com.ds.tree.bst.construct;

public class BSTToGreaterSumTree {

    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data   =   data;
            left = right = null;
        }
    }

    static Node root;
    static int sum =0;

    private static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public static void convertToGreaterSumTree(Node node){
        if(node == null) return;
        convertToGreaterSumTree(node.right);
        sum = sum + node.data;
        node.data   =   sum - node.data;
        convertToGreaterSumTree(node.left);
    }

    public static void main(String[] args) {
        root = new Node(11);
        root.left = new Node(2);
        root.right = new Node(29);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);
        inorder(root);
        System.out.println();
        convertToGreaterSumTree(root);
        inorder(root);
    }
}
