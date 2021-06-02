package com.ds.tree.bt.lowest.common.ancestor;

import java.util.ArrayList;
import java.util.List;

public class AncestorDescendentRelationshlip {

    static List<Node> nodeList = new ArrayList<>();

    public static boolean isParent(Node parent, Node child) {
        nodeList.clear();
        return findPath(parent, child, nodeList);
    }

    private static boolean findPath(Node parent, Node child, List<Node> nodeList) {
        if (parent == null) return false;
        nodeList.add(parent);
        if (parent.data == child.data) return true;
        if (parent.left != null && findPath(parent.left, child, nodeList)) return true;
        if (parent.right != null && findPath(parent.right, child, nodeList)) return true;
        nodeList.remove(nodeList.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right.left = new Node(7);
        System.out.println(isParent(root.right,root.right.right));
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
