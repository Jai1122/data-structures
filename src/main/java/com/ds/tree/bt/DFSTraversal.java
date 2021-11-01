package com.ds.tree.bt;

public class DFSTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.print("InOrder : ");
        dfsInOrder(root);
        System.out.println();
        System.out.print("Preorder : ");
        dfsPreOrder(root);
        System.out.println();
        System.out.print("PostOrder : ");
        dfsPostOrder(root);
    }

    public static void dfsInOrder(Node node) {
        if (node == null) return;
        dfsInOrder(node.left);
        System.out.print(node.data + " ");
        dfsInOrder(node.right);
    }

    public static void dfsPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        dfsPreOrder(node.left);
        dfsPreOrder(node.right);
    }

    public static void dfsPostOrder(Node node) {
        if (node == null) return;
        dfsPostOrder(node.left);
        dfsPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

}
