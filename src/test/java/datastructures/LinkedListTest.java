package datastructures;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> root = new LinkedList<Integer>(1);
        LinkedList<Integer> n2 = new LinkedList<Integer>(2);
        root.next = n2;

        LinkedList<Integer> node = root;
        do {
            System.out.println(node.data);
            node = node.next;
        } while(node != null);
    }
}
