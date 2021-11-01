package com.ds.tree.bt.misc;

public class BTDiameterNewMethod {

    static int diameter =   Integer.MIN_VALUE;

    public static int getHeight(Node node){
        if (node == null) return 0;
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        diameter    =   Math.max(diameter,1+lHeight+rHeight);
        return 1+ Math.max(lHeight,rHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        getHeight(root);
        System.out.println(diameter);
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
