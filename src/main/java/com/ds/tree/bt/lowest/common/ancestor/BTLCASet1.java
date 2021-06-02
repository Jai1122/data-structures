package com.ds.tree.bt.lowest.common.ancestor;

import java.util.LinkedList;
import java.util.List;

public class BTLCASet1 {

    static List<Node> nodeList1 = new LinkedList<>();
    static List<Node> nodeList2 = new LinkedList<>();

    public static int findLCA(Node root, Node n1, Node n2) {
        nodeList1.clear();
        nodeList2.clear();
        return findLCAInternal(root, n1, n2).data;
    }

    public static Node findLCAInternal(Node root, Node n1, Node n2) {
        if (!findPath(root, n1, nodeList1) || !findPath(root, n2, nodeList2)) {
            return null;
        }

        int i;
        for (i = 0; i < nodeList1.size() && i < nodeList2.size(); i++) {
            if (nodeList1.get(i).data != nodeList2.get(i).data) {
                break;
            }
        }
        return nodeList1.get(i - 1);
    }

    public static boolean findPath(Node root, Node n1, List<Node> nodeList) {
        if (root == null) return false;
        nodeList.add(root);
        if (root.data == n1.data) return true;
        if (root.left != null && findPath(root.left, n1, nodeList)) {
            return true;
        }
        if (root.right != null && findPath(root.right, n1, nodeList)) {
            return true;
        }
        nodeList.remove(nodeList.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(findLCA(root, root.left.left, root.left.right));
        System.out.println(findLCA(root, root.left.left, root.right.left));
        System.out.println(findLCA(root, root.right, root.left.left));
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
