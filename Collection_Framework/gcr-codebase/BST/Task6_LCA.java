public class Task6_LCA {

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

    static Node lowestCommonAncestor(Node root, int p, int q) {
        Node current = root;
        while (current != null) {
            if (p < current.val && q < current.val) {
                current = current.left;
            } else if (p > current.val && q > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //        50
        //       /  \
        //     30    70
        //    /  \   / \
        //  20  40  60  80
        Node root = null;
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) root = insert(root, v);

        System.out.println("Test 1 (20, 40): " + lowestCommonAncestor(root, 20, 40).val); // 30
        System.out.println("Test 2 (20, 80): " + lowestCommonAncestor(root, 20, 80).val); // 50
        System.out.println("Test 3 (60, 80): " + lowestCommonAncestor(root, 60, 80).val); // 70
        System.out.println("Test 4 (30, 40): " + lowestCommonAncestor(root, 30, 40).val); // 30
        System.out.println("Test 5 (50, 70): " + lowestCommonAncestor(root, 50, 70).val); // 50 (root itself)
    }
}
