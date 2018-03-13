package datastructures;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(int key) {
        root = new Node(key);
    }

    Node search(int key) {}
    int minimum() {}
    int maximum() {}
    Node predecessor(int key) {}
    Node successor(int key) {}
    void insert(int key) {}
    void delete(int key) {}
    void trim(int low, int high) {}

    static class Node {
        int key;
        Node left, right;
        public Node(int key) {
            this.key = key;
        }
    }
}
