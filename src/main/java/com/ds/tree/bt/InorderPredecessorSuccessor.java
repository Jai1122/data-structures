package com.ds.tree.bt;

import java.util.ArrayList;
import java.util.List;

public class InorderPredecessorSuccessor {

    //static List<Node> inorderList   =   new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        preorder(root);
        System.out.println();
        replaceWithInorderPredecessorAndSuccessorSum(root);
        preorder(root);
    }

    public static void replaceWithInorderPredecessorAndSuccessorSum(Node root) {
        List<Integer> inorderList = getInOrder(root, new ArrayList<>());
        //inorderList.forEach(node -> System.out.print(node.data+" "));
        System.out.println();
        replace(root, inorderList);
    }

    public static void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static int getPredecessor(Node node, List<Integer> inorderList) {
        int predecessor = inorderList.indexOf(node.data);
        return predecessor > 0 ? inorderList.get(predecessor - 1) : 0;
    }

    public static int getSuccessor(Node node, List<Integer> inorderList) {
        int successor = inorderList.indexOf(node.data);
        return successor == inorderList.size() - 1 ? 0 : inorderList.get(successor + 1);
    }

    public static void replace(Node node, List<Integer> inorderList) {
        if (node == null) {
            return;
        }

        replace(node.left, inorderList);
        int predecessor = getPredecessor(node, inorderList);
        int successor = getSuccessor(node, inorderList);
        node.data = predecessor + successor;
        replace(node.right, inorderList);
    }

    public static List<Integer> getInOrder(Node node, List<Integer> inorderList) {
        if (node == null) {
            return null;
        }
        getInOrder(node.left, inorderList);
        inorderList.add(node.data);
        getInOrder(node.right, inorderList);
        return inorderList;
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
