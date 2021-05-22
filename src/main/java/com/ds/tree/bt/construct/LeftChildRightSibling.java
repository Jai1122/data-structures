package com.ds.tree.bt.construct;

public class LeftChildRightSibling {

    public static Node addSibling(Node node, int data) {
        if (node == null) return null;
        if (node.sibling == null) {
            node.sibling = new Node(data);
        } else {
            while (node.sibling != null) {
                node = node.sibling;
            }
            node.sibling = new Node(data);
        }
        return node;
    }

    public static Node addChild(Node node, int data) {
        if (node == null) return null;
        if (node.child == null) {
            node.child = new Node(data);
        } else {
            Node child = node.child;
            addSibling(child, data);
        }
        return node;
    }

    public static void preorder(Node node) {
        if (node == null) return;

        while (node != null) {
            System.out.print(node.data + " ");
            if (node.child != null)
                preorder(node.child);
            node = node.sibling;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node n1 = addChild(root, 2);
        Node n2 = addChild(root, 3);
        Node n3 = addChild(root, 4);
        Node n4 = addChild(n3, 6);
        Node n5 = addChild(root, 5);
        Node n6 = addChild(n5, 7);
        Node n7 = addChild(n5, 8);
        Node n8 = addChild(n5, 9);
        preorder(root);
    }

    static class Node {
        int data;
        Node child;
        Node sibling;

        public Node(int data) {
            this.data = data;
            child = sibling = null;
        }
    }
}
