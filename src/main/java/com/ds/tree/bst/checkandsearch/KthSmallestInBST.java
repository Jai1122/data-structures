package com.ds.tree.bst.checkandsearch;

public class KthSmallestInBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int[] inorderArray;
    static int index = 0;

    public static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        inorderArray[index++]   =   node.data;
        inorder(node.right);
    }

    public static Node insert(Node node, int data){
        if(node == null){
            return new Node(data);
        }
        if(node.data > data){
            node.left = insert(node.left, data);
        }else
            node.right = insert(node.right,data);
        return node;
    }

    public static int findKthElement(Node node, int k){
        inorder(node);
        return inorderArray[k-1];
    }

    public static void main(String[] args) {
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
        Node root = null;
        for (int i = 0; i < keys.length; i++) {
            root = insert(root,keys[i]);
        }
        inorderArray = new int[keys.length];
        System.out.println(findKthElement(root,3));
    }
}
