package com.ds.tree.bt.misc;

public class Isomorphic {

    public static boolean isIsoMorphic(Node root1, Node root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return (root1.data == root2.data) && ((isIsoMorphic(root1.left,root2.left) &&
                isIsoMorphic(root1.right,root2.right)) || (isIsoMorphic(root1.left,root2.right) &&
                isIsoMorphic(root1.right,root2.left)) );
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.left.right.left = new Node(7);
        root1.left.right.right = new Node(8);
        
        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.left = new Node(4);
        root2.right.right = new Node(5);
        root2.left.right = new Node(6);
        root2.right.right.left = new Node(8);
        root2.right.right.right = new Node(7);

        System.out.println(isIsoMorphic(root1,root2));
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
