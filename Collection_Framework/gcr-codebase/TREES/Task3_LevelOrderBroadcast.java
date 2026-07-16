import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Task3_LevelOrderBroadcast {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static List<List<Integer>> broadcastByLevel(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
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

        System.out.println("Test 1: " + broadcastByLevel(root));
        // [[1], [2, 3], [4, 5, 6]]

        // Left-skewed
        Node leftSkewed = new Node(1);
        leftSkewed.left = new Node(2);
        leftSkewed.left.left = new Node(3);
        System.out.println("Test 2 (left-skewed): " + broadcastByLevel(leftSkewed));
        // [[1], [2], [3]]

        // Single node
        System.out.println("Test 3 (single): " + broadcastByLevel(new Node(10)));
        // [[10]]

        // Empty
        System.out.println("Test 4 (empty): " + broadcastByLevel(null));
        // []
    }
}
