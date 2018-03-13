package datastructures;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);

        Integer data = queue.dequeue();
        while (data != null) {
            System.out.println(data);
            data = queue.dequeue();
        }
    }
}
