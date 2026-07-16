public class Task1_Search {

    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static boolean search(Node root, int target) {
        Node current = root;
        while (current != null) {
            if (target == current.val) return true;
            current = (target < current.val) ? current.left : current.right;
        }
        return false;
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

        System.out.println("Test 1 (find 40): " + search(root, 40));   // true
        System.out.println("Test 2 (find 70): " + search(root, 70));   // true
        System.out.println("Test 3 (find 25): " + search(root, 25));   // false
        System.out.println("Test 4 (find 100): " + search(root, 100)); // false
        System.out.println("Test 5 (empty tree): " + search(null, 1)); // false
    }
}
