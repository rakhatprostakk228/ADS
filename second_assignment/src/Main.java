import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top of stack: " + stack.peek());
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        System.out.println("Front of queue: " + queue.peek());
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(3);
        heap.insert(1);
        heap.insert(5);
        heap.insert(2);
        System.out.println("Minimum element: " + heap.getMin());
        while (!heap.isEmpty()) {
            System.out.println("Extracted min: " + heap.deleteMin());
        }
    }
}