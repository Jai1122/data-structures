package com.ds.tree.bt.lowest.common.ancestor;

public class MaxAncestorDistance {

    private static int maxDiff(Node root){
        Result res = new Result();
        maxDiffUtil(root,res);
        return res.r;
    }

    private static int maxDiffUtil(Node node, Result res){
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right ==  null)
            return node.data;
        int val = Math.min(maxDiffUtil(node.left,res),maxDiffUtil(node.right,res));
        res.r   =   Math.max(res.r,node.data-val);
        return Math.min(val,node.data);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        System.out.println(maxDiff(root));
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


class Result{
    int r   =   Integer.MIN_VALUE;
}