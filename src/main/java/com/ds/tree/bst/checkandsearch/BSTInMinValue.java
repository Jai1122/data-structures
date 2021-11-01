package com.ds.tree.bst.checkandsearch;

public class BSTInMinValue {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    //static Node root;

    public static Node insert(int data, Node root){
        Node node = new Node(data);
        if(root == null) {
            root = node;
            return root;
        }
        if(node.data < root.data){
            root.left   =   insert(data, root.left);
        }else{
            root.right  =   insert(data, root.right);
        }
        return root;
    }

    public static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data+ " ");
        inorder(node.right);
    }

    public static int findMinValue(Node node){
        while(node.left!=null){
            node = node.left;
        }
        return node.data;
    }

    public static void main(String[] args) {
        Node root = insert(4,null);
        root = insert(2, root);
        root = insert(1, root);
        root = insert(3, root);
        root = insert(6, root);
        root = insert(5, root);
        inorder(root);
        System.out.println("Min Value is "+findMinValue(root));
    }
}
