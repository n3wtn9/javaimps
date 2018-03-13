package datastructures;

/**
 * FIFO
 * @param <E>
 */
public class Stack<E> {
    Node<E> top;

    E pop() {
        if (top != null) {
            E data = top.data;
            top = top.next;
            return data;
        }
        return null;
    }

    void push(E data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    E peek() {
        if (top != null) {
            return top.data;
        }
        return null;
    }

    static class Node<E> {
        E data;
        Node next;
        public Node(E data) {
            this.data = data;
        }
    }
}
