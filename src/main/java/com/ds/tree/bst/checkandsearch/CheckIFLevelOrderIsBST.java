package com.ds.tree.bst.checkandsearch;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIFLevelOrderIsBST {

    public static boolean isBST(int[] lvlorder) {

        int index = 0;
        int n = lvlorder.length;
        NodeDetails nodeDetails = new NodeDetails();
        Queue<NodeDetails> queue = new LinkedList<>();
        nodeDetails.data = lvlorder[index++];
        nodeDetails.min = Integer.MIN_VALUE;
        nodeDetails.max = Integer.MAX_VALUE;
        queue.add(nodeDetails);
        while (index != n && !queue.isEmpty()) {
            NodeDetails temp = queue.poll();
            nodeDetails = new NodeDetails();
            if (index < n && lvlorder[index] < temp.data && lvlorder[index] > temp.min) {
                nodeDetails.data = lvlorder[index++];
                nodeDetails.min = temp.min;
                nodeDetails.max = temp.data;
                queue.add(nodeDetails);
            }
            nodeDetails = new NodeDetails();
            if (index < n && lvlorder[index] > temp.data && lvlorder[index] < temp.max) {
                nodeDetails.data = lvlorder[index++];
                nodeDetails.min = temp.data;
                nodeDetails.max = temp.max;
                queue.add(nodeDetails);
            }
        }
        return index == n;
    }

    public static void main(String[] args) {
        int[] lvlOrder = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        System.out.println("Is BST? " + isBST(lvlOrder));
    }

    static class NodeDetails {
        public int min;
        public int max;
        public int data;
    }
}
