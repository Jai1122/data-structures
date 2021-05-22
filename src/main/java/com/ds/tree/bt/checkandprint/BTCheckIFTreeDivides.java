package com.ds.tree.bt.checkandprint;

public class BTCheckIFTreeDivides {

    static boolean flag = false;

    public static boolean checkHalves(Node node) {
        int count = countNodes(node);
        nodeLookUp(node, count);
        return flag;
    }

    private static int nodeLookUp(Node node, int count) {
        if (node == null) return 0;
        int c = nodeLookUp(node.left, count) + 1 + nodeLookUp(node.right, count);
        if (count - c == c) flag = true;
        return c;
    }

    private static int countNodes(Node node) {
        if (node == null) return 0;
        return countNodes(node.left) + 1 + countNodes(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.right.left = new Node(7);
        root.right.right = new Node(4);
        System.out.println(checkHalves(root));
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
