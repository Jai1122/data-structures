package com.ds.tree.bt.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class BTChildrenSumProperty {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        System.out.println(isChildSum(root));
    }

    public static boolean isChildSum(Node node) {
        boolean isChildSumFlag = true;

        if (node == null) return isChildSumFlag;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int nodeData = temp.data;
            int leftData = 0;
            int rightData = 0;

            if (temp.left != null) {
                leftData = temp.left.data;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                rightData = temp.right.data;
                queue.add(temp.right);
            }

            if ((temp.left != null || temp.right != null) && nodeData != leftData + rightData) {
                return false;
            }
        }
        return isChildSumFlag;
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
