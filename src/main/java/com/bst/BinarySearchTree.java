package com.bst;

import java.util.Comparator;

class BinaryTree<E extends Comparable<E>> {

    private class Node {
        E value;
        Node left, right;

        Node(E value) {
            this.value = value;
        }
    }

    private Node root;

    // Insert
    public void insert(E value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, E value) {
        if (node == null) return new Node(value);

        if (value.compareTo(node.value) < 0)
            node.left = insertRec(node.left, value);
        else
            node.right = insertRec(node.right, value);

        return node;
    }

    // search
    public E search(E value) {
        return searchRec(root, value);
    }

    private E searchRec(Node node, E value) {
        if (node == null) return null;

        int compare = value.compareTo(node.value);

        if (compare == 0) 
            return node.value;
        else if (compare < 0) 
            return searchRec(node.left, value);
        else 
            return searchRec(node.right, value);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }
}