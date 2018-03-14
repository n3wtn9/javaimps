package datastructures;

public class BinarySearchTree {
    Node root;

    Node search(Node n, int key) {
        if (n == null) return null;

        if (key < n.key)
            return search(n.left, key);
        else if (key > n.key)
            return search(n.right, key);
        else
            return n;
    }

    Node minimum(Node n) {
        while (n.left != null)
            n = n.left;
        return n;
    }

    Node maximum(Node n) {
        while(n.right != null)
            n = n.right;
        return n;
    }

    Node successor(Node n) {
        if (n.right != null)
            return minimum(n.right);

        Node p = n.parent;
        while (p != null && p.right == n) {
            n = p;
            p = n.parent;
        }
        return p;
    }

    // no parent
    Node secessor2(Node n) { return n; }

    Node predecessor(Node n) {
        if (n.left != null)
            return maximum(n.right);

        Node p = n.parent;
        while (p != null && p.left == n) {
            n = p;
            p = n.parent;
        }
        return p;
    }

    // no parent
    Node predecessor2(Node n) { return n; }

    void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        Node next = root;
        Node parent;
        do {
            parent = next;
            if (key < next.key)
                next = next.left;
            else if (key > next.key)
                next = next.right;
            else
                return;
        }
        while (next != null);

        if (key < parent.key) {
            parent.left = new Node(key);
            parent.left.parent = parent;
        } else {
            parent.right = new Node(key);
            parent.right.parent = parent;
        }
    }

    void delete(Node n) {
        if (n.left == null) {
            transplant(n, n.right);
        } else if (n.right == null) {
            transplant(n, n.left);
        } else {
            Node min = minimum(n.right);
            if (min.parent != n) {
                transplant(min, min.right);
                min.right = n.right;
                min.right.parent = min;
            }
            transplant(n, min);
            min.left = n.left;
            min.left.parent = min;
        }
    }

    void transplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
            return;
        }

        if (u == u.parent.right)
            u.parent.right = v;
        else
            u.parent.left = v;

        if (v != null)
            v.parent = u.parent;
    }

    Node trim(Node n, int low, int high) {
        if (n == null) return null;

        n.left = trim(n.left, low, high);
        n.right = trim(n.right, low, high);

        if (n.key < low)
            return n.right;
        else if (n.key > high)
            return n.left;
        else
            return n;
    }

    void rotateLeft() {
        Node tmp = root.right;
        root.right = root.right.left;
        tmp.left = root;
        root = tmp;
    }

    void rotateRight() {
        Node tmp = root.left;
        root.left = root.left.right;
        tmp.right = root;
        root = tmp;
    }

    static class Node {
        int key;
        Node left, right, parent;

        public Node(int key) {
            this.key = key;
        }
    }
}
