import java.util.LinkedList;
import java.util.Queue;

// LeetCode 225: Implement Stack using Queues

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

public class LC225_StackUsingQueues {
    public static void main(String[] args) {
        System.out.println("=== LeetCode 225: Implement Stack using Queues ===\n");

        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Stack after pushes [1,2,3]: top = " + s.top());
        System.out.println("pop = " + s.pop());
        System.out.println("top = " + s.top());
        s.push(4);
        System.out.println("After push(4): top = " + s.top());
        System.out.println("pop = " + s.pop());
        System.out.println("pop = " + s.pop());
        System.out.println("empty = " + s.empty());
    }
}
