class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Deletion {

    public static Node deleteNode(Node head, int key) {

        if (head == null)
            return null;

        // Delete first node
        if (head.data == key) {
            return head.next;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }

        // Node not found
        if (curr == null)
            return head;

        // Delete node
        prev.next = curr.next;

        return head;
    }
}