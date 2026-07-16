import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Task2_IterativePreorder {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static List<Integer> iterativePreorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Test 1 (balanced): " + iterativePreorder(root));
        // [1, 2, 4, 5, 3, 6]

        // Deep left-skewed (would cause StackOverflow with recursion)
        Node deep = new Node(1);
        Node current = deep;
        for (int i = 2; i <= 100000; i++) {
            current.left = new Node(i);
            current = current.left;
        }
        List<Integer> result = iterativePreorder(deep);
        System.out.println("Test 2 (deep chain, size=" + result.size() + "): first=" + result.get(0) + " last=" + result.get(result.size() - 1));
        // [1, 2, 3, ..., 100000]

        // Single node
        System.out.println("Test 3 (single): " + iterativePreorder(new Node(99)));
        // [99]

        // Empty
        System.out.println("Test 4 (empty): " + iterativePreorder(null));
        // []
    }
}
