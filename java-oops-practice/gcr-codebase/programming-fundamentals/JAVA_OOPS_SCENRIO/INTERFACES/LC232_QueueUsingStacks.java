import java.util.Stack;

// LeetCode 232: Implement Queue using Stacks

class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

public class LC232_QueueUsingStacks {
    public static void main(String[] args) {
        System.out.println("=== LeetCode 232: Implement Queue using Stacks ===\n");

        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("Queue after pushes [1,2,3]: peek = " + q.peek());
        System.out.println("pop = " + q.pop());
        System.out.println("pop = " + q.pop());
        q.push(4);
        System.out.println("After push(4): peek = " + q.peek());
        System.out.println("pop = " + q.pop());
        System.out.println("pop = " + q.pop());
        System.out.println("empty = " + q.empty());
    }
}
