package com.ds.tree.bst.checkandsearch;

public class LCAOfBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int findLCA(Node root, int n1, int n2){

        while(root != null){
            if(root.data < n1 && root.data <  n2){
                root = root.right;
            }else if(root.data > n1 && root.data > n2){
                root = root.left;
            }else {
                break;
            }
        }

        return root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(findLCA(root, 10, 14));
    }
}
