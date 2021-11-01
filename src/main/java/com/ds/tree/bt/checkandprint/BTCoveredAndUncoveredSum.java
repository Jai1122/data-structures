package com.ds.tree.bt.checkandprint;

public class BTCoveredAndUncoveredSum {
    static int total = 0;
    static int lSum = 0;
    static int rSum = 0;

    public static void treeSum(Node node) {
        if (node == null) return;
        treeSum(node.left);
        total += node.data;
        treeSum(node.right);
    }

    public static void setlSum(Node node) {
        if (node == null) return;
        while (node != null) {
            if (node.left == null && node.right == null) {
                //    lSum += node.data;
                break;
            } else if (node.left != null) {
                node = node.left;
                lSum += node.data;
            } else {
                node = node.right;
                lSum += node.data;
            }
        }
    }

    public static void setRSum(Node node) {
        if (node == null) return;
        while (node != null) {
            if (node.left == null && node.right == null) {
                //rSum += node.data;
                break;
            } else if (node.right != null) {
                node = node.right;
                rSum += node.data;
            } else {
                node = node.left;
                rSum += node.data;
            }
            //System.out.println(rSum);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(4);
        root.right = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(22);
        root.right.right.left = new Node(20);
        treeSum(root);
        setlSum(root);
        setRSum(root);
        int covered = lSum + rSum + root.data;
        int uncovered = total - (lSum + rSum + root.data);
        System.out.println("Total Sum: " + total);
        System.out.println("Left Sum: " + lSum);
        System.out.println("Right Sum: " + rSum);
        System.out.println("Covered " + ((lSum + rSum + root.data)));
        System.out.println("Uncovered " + (total - (lSum + rSum + root.data)));
        if (covered != uncovered) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
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
