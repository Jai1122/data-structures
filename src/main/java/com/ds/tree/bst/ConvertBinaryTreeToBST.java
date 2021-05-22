package com.ds.tree.bst;
//https://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
/*
        1) Create a temp array arr[] that stores inorder traversal of the tree. This step takes O(n) time.
        2) Sort the temp array arr[]. Time complexity of this step depends upon the sorting algorithm.
            In the following implementation, Quick Sort is used which takes (n^2) time.
            This can be done in O(nLogn) time using Heap Sort or Merge Sort.
        3) Again do inorder traversal of tree and copy array elements to tree nodes one by one.
            This step takes O(n) time.
*/


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ConvertBinaryTreeToBST {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        //Extract and sort the keys in ascending order
        Set<Integer> set = new TreeSet<>();
        extractKeys(root, set);
        Iterator<Integer> it = set.iterator();
        //Inorder traversal on the root with set
        convertToBst(root, it);
        inorder(root);
    }

    private static void convertToBst(Node node, Iterator<Integer> it) {
        if (node == null) return;
        convertToBst(node.left, it);
        node.data = it.next();
        convertToBst(node.right, it);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    //inorder traversal of given binary tree
    public static void extractKeys(Node node, Set<Integer> set) {
        if (node == null) return;
        extractKeys(node.left, set);
        set.add(node.data);
        extractKeys(node.right, set);
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
