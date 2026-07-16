public class Task3_Delete {

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

    static Node delete(Node node, int sku) {
        if (node == null) return null;
        if (sku < node.val) {
            node.left = delete(node.left, sku);
        } else if (sku > node.val) {
            node.right = delete(node.right, sku);
        } else {
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.val = successor.val;
            node.right = delete(node.right, successor.val);
        }
        return node;
    }

    static void inorder(Node node, StringBuilder sb) {
        if (node == null) return;
        inorder(node.left, sb);
        sb.append(node.val).append(" ");
        inorder(node.right, sb);
    }

    public static void main(String[] args) {
        Node root = null;
        for (int v : new int[]{50, 30, 70, 20, 40, 60, 80}) root = insert(root, v);

        // Case 1: delete leaf (20)
        root = delete(root, 20);
        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("Test 1 (delete leaf 20): " + sb.toString().trim());
        // 30 40 50 60 70 80

        // Case 2: delete node with one child (70 -> only right child 80)
        root = delete(root, 70);
        sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("Test 2 (delete one-child 70): " + sb.toString().trim());
        // 30 40 50 60 80

        // Case 3: delete node with two children (50 -> successor 60)
        root = delete(root, 50);
        sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("Test 3 (delete two-children 50): " + sb.toString().trim());
        // 30 40 60 80

        // Delete non-existent
        root = delete(root, 999);
        sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("Test 4 (delete nonexistent 999): " + sb.toString().trim());
        // 30 40 60 80
    }
}
