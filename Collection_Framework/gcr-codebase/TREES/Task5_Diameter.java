public class Task5_Diameter {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static int diameter;

    static int heightAndUpdateDiameter(Node node) {
        if (node == null) return -1;
        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight + 2);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int longestCommunicationPath(Node root) {
        diameter = 0;
        heightAndUpdateDiameter(root);
        return diameter;
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

        System.out.println("Test 1: " + longestCommunicationPath(root)); // 3 (4->2->1->3 or 5->2->1->3)

        // Longest path does NOT pass through root:
        //        1
        //       /
        //      2
        //     / \
        //    3   4
        //   /     \
        //  5       6
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);
        root2.left.right = new Node(4);
        root2.left.left.left = new Node(5);
        root2.left.right.right = new Node(6);

        System.out.println("Test 2: " + longestCommunicationPath(root2)); // 4 (5->3->2->4->6)

        // Single node
        System.out.println("Test 3 (single): " + longestCommunicationPath(new Node(10))); // 0

        // Empty
        System.out.println("Test 4 (empty): " + longestCommunicationPath(null)); // 0

        // Linear chain
        Node chain = new Node(1);
        chain.right = new Node(2);
        chain.right.right = new Node(3);
        System.out.println("Test 5 (chain): " + longestCommunicationPath(chain)); // 2
    }
}
