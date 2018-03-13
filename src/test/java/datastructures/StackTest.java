package datastructures;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);

        while (stack.peek() !=null) {
            int data = stack.pop();
            System.out.println(data);
        }
    }
}
