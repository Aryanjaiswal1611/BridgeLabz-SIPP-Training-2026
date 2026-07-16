import java.util.ArrayList;
import java.util.List;

public class Task1_SortedLeaderboard {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static void inorder(Node node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    static List<Integer> getSortedLeaderboard(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public static void main(String[] args) {
        //        50
        //       /  \
        //     30    70
        //    /  \   / \
        //  20  40  60  80
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("Test 1 (balanced BST): " + getSortedLeaderboard(root));
        // [20, 30, 40, 50, 60, 70, 80]

        // Skewed BST (right-only)
        Node skewed = new Node(1);
        skewed.right = new Node(2);
        skewed.right.right = new Node(3);
        skewed.right.right.right = new Node(4);
        System.out.println("Test 2 (right-skewed): " + getSortedLeaderboard(skewed));
        // [1, 2, 3, 4]

        // Single node
        Node single = new Node(42);
        System.out.println("Test 3 (single node): " + getSortedLeaderboard(single));
        // [42]

        // Empty tree
        System.out.println("Test 4 (empty): " + getSortedLeaderboard(null));
        // []
    }
}
