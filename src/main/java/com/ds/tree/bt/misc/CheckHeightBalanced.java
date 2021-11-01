package com.ds.tree.bt.misc;

import java.util.Arrays;
import java.util.List;

public class CheckHeightBalanced {

    public static boolean isHeightBalanced(Node root){
        if (root == null) return true;
        return isHeightBalanced(root.left) && isHeightBalanced(root.right) &&
                (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1);
    }

    private static int getHeight(Node node){
        if (node == null) return 0;
        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        return 1+ Math.max(lHeight,rHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left   =   new Node(2);
        root.right  =   new Node(3);
        root.left.left  =   new Node(4);
        System.out.println(isHeightBalanced(root));
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
