package com.ds.tree.bt.misc;

public class BTDiameter {

    public static int diameter(Node root){
        if (root == null) return 0;
        int lHeight =   getHeight(root.left);
        int rHeight =   getHeight(root.right);

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);
        return Math.max(1+lHeight+rHeight,Math.max(lDiameter,rDiameter));
    }

    private static int getHeight(Node node){
        if (node == null) return 0;
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return 1+Math.max(lHeight,rHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(diameter(root));
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
