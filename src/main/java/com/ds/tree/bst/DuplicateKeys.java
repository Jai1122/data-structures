package com.ds.tree.bst;

public class DuplicateKeys {

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 9);
        root = insert(root, 11);
        root = insert(root, 10);
        root = insert(root, 12);
        root = insert(root, 12);
        inorder(root);
        System.out.print("\nDelete 20\n");
        root = delete(root, 20);
        System.out.print("Inorder traversal of " +
                "the modified tree \n");
        inorder(root);
        System.out.print("\nDelete 12\n");
        root = delete(root, 12);
        System.out.print("Inorder traversal of " +
                "the modified tree \n");
        inorder(root);
        System.out.print("\nDelete 9\n");
        root = delete(root, 9);
        System.out.print("Inorder traversal of " +
                "the modified tree \n");
        inorder(root);
    }

    public static Node delete(Node node, int data) {
        if (node == null) return node;
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if (node.count > 1) {
                node.count--;
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    Node replacementNode = findReplacement(node.right);
                    node.data = replacementNode.data;
                    node.count = replacementNode.count;
                    node.right = delete(node.right, node.data);
                }
            }

        }
        return node;
    }

    public static Node findReplacement(Node node) {
        if (node == null) return node;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else if (node.data == data) {
            node.count++;
        } else if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + "(" + node.count + ") ");
        inorder(node.right);
    }

    static class Node {
        int data;
        int count;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.count = 1;
            left = right = null;
        }
    }
}
