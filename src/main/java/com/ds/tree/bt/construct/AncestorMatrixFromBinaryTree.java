package com.ds.tree.bt.construct;

import java.util.LinkedList;
import java.util.Queue;

public class AncestorMatrixFromBinaryTree {

    public static int[][] constructAncestorMatrix(Node node, int[][] mat) {
        if (node == null) return mat;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.left != null) {
                Node left = temp.left;
                mat[temp.data][left.data] = 1;
                queue.add(temp.left);
            }
            if (temp.right != null) {
                Node right = temp.right;
                mat[temp.data][right.data] = 1;
                queue.add(right);
            }
        }

        //Applying transitive closure to update parent of parent node
        //TODO I did not understand below piece
        int size = mat.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (mat[j][k] == 1)
                        mat[j][k] = 1;
                    else if ((mat[j][i] == 1 && mat[i][k] == 1))
                        mat[j][k] = 1;
                }
            }

        }
        return mat;
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node tree_root = new Node(5);
        tree_root.left = new Node(1);
        tree_root.right = new Node(2);
        tree_root.left.left = new Node(0);
        tree_root.left.right = new Node(4);
        tree_root.right.left = new Node(3);
        int[][] mat = new int[6][6];
        printMatrix(constructAncestorMatrix(tree_root, mat));
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
