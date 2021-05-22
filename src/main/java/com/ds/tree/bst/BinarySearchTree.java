package com.ds.tree.bst;

public class BinarySearchTree {

    Node root;
    int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.traverse();
     /*   System.out.println("Size :" + binarySearchTree.size);
        System.out.println("Deletion");
        binarySearchTree.delete(20);
        binarySearchTree.traverse();
        System.out.println();
        binarySearchTree.delete(30);
        binarySearchTree.traverse();
        System.out.println();
        binarySearchTree.delete(100);
        binarySearchTree.traverse();
        System.out.println("Size :" + binarySearchTree.size);
     */
        System.out.println("Depth : " + binarySearchTree.getDepth(50));
        System.out.println("Height :" + binarySearchTree.getHeight(50));
        System.out.println("Depth : " + binarySearchTree.getDepth(40));
        System.out.println("Height :" + binarySearchTree.getHeight(40));
        System.out.println("Depth : " + binarySearchTree.getDepth(70));
        System.out.println("Height :" + binarySearchTree.getHeight(70));
        System.out.println("Level Order");
        binarySearchTree.levelOrder();
    }

    public Node insert(int key) {
        root = insertKey(root, key);
        return root;
    }

    public int getDepth(int key) {
        Node node = root;
        if (root.key == key) return 0;
        int depth = 0;
        while (node != null && node.key != key) {
            if (node.key > key) {
                depth++;
                node = node.left;
            } else {
                depth++;
                node = node.right;
            }
        }
        return depth;
    }

    public int getDepth(Node node) {
        int depth = 0;
        Node temp = root;
        while (node != null && node.key != temp.key) {
            if (node.key < temp.key) {
                depth++;
                node = node.left;
            } else {
                depth++;
                node = node.right;
            }
        }
        return depth;
    }

    public int getHeight(int key) {
        int height = 0;
        Node node = root;
        while (node.key != key) {
            if (key <= node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (key == node.key) {
            height = findHeight(node);
        } else {
            System.err.println("Invalid node");
            return -1;
        }
        return height;
    }

    private int findHeight(Node node) {
        if (node == null) return -1;
        int lheight = findHeight(node.left);
        int rheight = findHeight(node.right);
        return Math.max(lheight, rheight) + 1;
    }

    private Node insertKey(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            ++size;
            return node;
        }
        if (key <= node.key) {
            node.left = insertKey(node.left, key);
        } else {
            node.right = insertKey(node.right, key);
        }

        return node;
    }

    public void delete(int key) {
        root = deleteKey(root, key);
    }

    private Node deleteKey(Node node, int key) {
        if (node == null) {
            System.err.println("Invalid parameter to delete");
            return node;
        }
        //NOTE : Do not make this <=
        if (key < node.key) {
            node.left = deleteKey(node.left, key);
        } else if (key > node.key) {
            node.right = deleteKey(node.right, key);
        } else {
            if (node.left == null) {
                --size;
                return node.right;
            } else if (node.right == null) {
                --size;
                return node.left;
            }
            //Min value has to be calculated only if right subtree is not empty
            node.key = minValue(node.right);
            node.right = deleteKey(node.right, node.key);

        }
        return node;
    }

    public void traverse() {
        inorder(root);
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.key + " ");
    }

    public void levelOrder() {
        int height = findHeight(root) + 1;
        for (int i = 1; i <= height; i++) {
            levelOrder(root, i);
        }
    }

    private void levelOrder(Node node, int level) {
        if (node == null) {
            return;
        } else if (level == 1) {
            System.out.println(node.key);
        } else if (level > 1) {
            levelOrder(node.left, level - 1);
            levelOrder(node.right, level - 1);
        }
    }

    private int minValue(Node node) {
        int minVal = node.key;
        while (node.left != null) {
            minVal = node.left.key;
            node = node.left;
        }

        return minVal;
    }

    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

}
