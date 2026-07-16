public class Task2_Insert {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static Node insert(Node node, int id) {
        if (node == null) {
            return new Node(id);
        }
        if (id < node.val) {
            node.left = insert(node.left, id);
        } else if (id > node.val) {
            node.right = insert(node.right, id);
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
        int[] ids = {50, 30, 70, 20, 40, 60, 80};
        for (int id : ids) root = insert(root, id);

        StringBuilder sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("Test 1 (initial): " + sb.toString().trim()); // 20 30 40 50 60 70 80

        root = insert(root, 35);
        sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("Test 2 (insert 35): " + sb.toString().trim()); // 20 30 35 40 50 60 70 80

        root = insert(root, 90);
        sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("Test 3 (insert 90): " + sb.toString().trim()); // 20 30 35 40 50 60 70 80 90

        root = insert(root, 50);
        sb = new StringBuilder();
        inorder(root, sb);
        System.out.println("Test 4 (insert dup 50, unchanged): " + sb.toString().trim()); // same
    }
}
