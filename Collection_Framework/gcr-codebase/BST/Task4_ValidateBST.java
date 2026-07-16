public class Task4_ValidateBST {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(Node node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Valid BST
        //        50
        //       /  \
        //     30    70
        //    /  \   / \
        //  20  40  60  80
        Node valid = new Node(50);
        valid.left = new Node(30);
        valid.right = new Node(70);
        valid.left.left = new Node(20);
        valid.left.right = new Node(40);
        valid.right.left = new Node(60);
        valid.right.right = new Node(80);
        System.out.println("Test 1 (valid BST): " + isValidBST(valid)); // true

        // Invalid: root's left child's right child violates BST
        //        50
        //       /  \
        //     30    70
        //    /  \
        //  20   60  <-- 60 > 50, violates BST for root
        Node invalid = new Node(50);
        invalid.left = new Node(30);
        invalid.right = new Node(70);
        invalid.left.left = new Node(20);
        invalid.left.right = new Node(60);
        System.out.println("Test 2 (invalid - 60 in left subtree of 50): " + isValidBST(invalid)); // false

        // Single node
        System.out.println("Test 3 (single): " + isValidBST(new Node(10))); // true

        // Empty
        System.out.println("Test 4 (empty): " + isValidBST(null)); // true

        //        2
        //       / \
        //      1   3
        //           \
        //            4
        Node valid2 = new Node(2);
        valid2.left = new Node(1);
        valid2.right = new Node(3);
        valid2.right.right = new Node(4);
        System.out.println("Test 5 (valid chain): " + isValidBST(valid2)); // true
    }
}
