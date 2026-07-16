import java.util.ArrayList;
import java.util.List;

public class Task6_PostorderDelete {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
        @Override
        public String toString() { return String.valueOf(val); }
    }

    static List<Integer> deletedOrder;

    static void deleteFolderTree(Node node) {
        if (node == null) return;
        deleteFolderTree(node.left);
        deleteFolderTree(node.right);
        deleteNode(node);
    }

    static void deleteNode(Node node) {
        deletedOrder.add(node.val);
    }

    static List<Integer> getDeletionOrder(Node root) {
        deletedOrder = new ArrayList<>();
        deleteFolderTree(root);
        return deletedOrder;
    }

    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Test 1: " + getDeletionOrder(root));
        // [4, 5, 2, 3, 1] — children deleted before parents

        // Right-skewed
        Node skewed = new Node(1);
        skewed.right = new Node(2);
        skewed.right.right = new Node(3);
        System.out.println("Test 2 (right-skewed): " + getDeletionOrder(skewed));
        // [3, 2, 1]

        // Single node
        System.out.println("Test 3 (single): " + getDeletionOrder(new Node(42)));
        // [42]

        // Empty
        System.out.println("Test 4 (empty): " + getDeletionOrder(null));
        // []
    }
}
