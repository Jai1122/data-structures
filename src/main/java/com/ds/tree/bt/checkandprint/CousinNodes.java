package com.ds.tree.bt.checkandprint;

public class CousinNodes {


    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.left = new Node(1);
        root.right.right = new Node(3);
        System.out.println(isCousin(root, root.left.left, root.right.right));
    }

    public static boolean isSibling(Node root, Node a, Node b) {
        if (root == null || a == null || b == null) return false;
        return (root.left == a && root.right == b) || (root.left == b && root.right == a)
                || (isSibling(root.left, a, b) || isSibling(root.right, a, b));
    }

    public static int getLevel(Node root, Node node, int level) {
        if (root == null) return 0;
        if (root == node) return level;
        int llevel = getLevel(root.left, node, level + 1);
        if (llevel != 0) return llevel;
        return getLevel(root.right, node, level + 1);

    }

    public static boolean isCousin(Node root, Node a, Node b) {
        return (getLevel(root, a, 0) == getLevel(root, b, 0) && (!isSibling(root, a, b)));
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
