public class Task4_TreeHeight {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static int height(Node node) {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static boolean isTooDeep(Node root, int threshold) {
        return height(root) > threshold;
    }

    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //     /
        //    4
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("Test 1 height: " + height(root)); // 2
        System.out.println("Test 1 tooDeep(1): " + isTooDeep(root, 1)); // true (2 > 1)
        System.out.println("Test 1 tooDeep(2): " + isTooDeep(root, 2)); // false (2 > 2 is false)
        System.out.println("Test 1 tooDeep(3): " + isTooDeep(root, 3)); // false

        //        1
        //       /
        //      2
        //     /
        //    3
        //   /
        //  4
        Node deep = new Node(1);
        deep.left = new Node(2);
        deep.left.left = new Node(3);
        deep.left.left.left = new Node(4);

        System.out.println("Test 2 height: " + height(deep)); // 3
        System.out.println("Test 2 tooDeep(2): " + isTooDeep(deep, 2)); // true

        // Single node
        System.out.println("Test 3 height: " + height(new Node(10))); // 0

        // Empty
        System.out.println("Test 4 height: " + height(null)); // -1
    }
}
