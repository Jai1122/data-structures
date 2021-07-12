package com.ds.tree.bst.checkandsearch;

public class CheckIfBTIsBST {
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

    private static void fillArray(Node node){
        if(node == null) return;
        fillArray(node.left);
        inorderArray[index++] = node.data;
        fillArray(node.right);
    }

    public static boolean isBST(Node node){
        fillArray(node);
        for (int i = 0; i < inorderArray.length-1; i++) {
            if(inorderArray[i] > inorderArray[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        inorderArray    = new int[5];
        System.out.println(isBST(root));
    }
}
