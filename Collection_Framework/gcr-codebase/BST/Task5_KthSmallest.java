import java.util.ArrayDeque;
import java.util.Deque;

public class Task5_KthSmallest {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static Node insert(Node node, int val) {
        if (node == null) return new Node(val);
        if (val < node.val) node.left = insert(node.left, val);
        else if (val > node.val) node.right = insert(node.right, val);
        return node;
    }

    static int kthSmallest(Node root, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        int count = 0;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            count++;
            if (count == k) return current.val;
            current = current.right;
        }
        throw new IllegalArgumentException("k out of range");
    }

    public static void main(String[] args) {
        Node root = null;
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) root = insert(root, v);
        // Inorder: 20, 30, 40, 50, 60, 70, 80

        System.out.println("Test 1 (1st): " + kthSmallest(root, 1));  // 20
        System.out.println("Test 2 (3rd): " + kthSmallest(root, 3));  // 40
        System.out.println("Test 3 (5th): " + kthSmallest(root, 5));  // 60
        System.out.println("Test 4 (7th): " + kthSmallest(root, 7));  // 80

        try {
            kthSmallest(root, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 5 (k=10 out of range): " + e.getMessage());
        }
    }
}
