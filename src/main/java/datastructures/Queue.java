package datastructures;

/**
 * LIFO
 * @param <E>
 */
public class Queue<E> {
    Node<E> first, last;

    void enqueue(E data) {
        Node n = new Node(data);
        if (last == null) {
            last = n;
            first = last;
        } else {
            last.next = n;
            last = n;
        }
    }

    E dequeue() {
        if (first != null) {
            E data = first.data;
            first = first.next;
            return data;
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
