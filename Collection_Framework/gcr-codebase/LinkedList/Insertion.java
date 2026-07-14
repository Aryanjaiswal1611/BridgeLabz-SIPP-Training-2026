class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Insertion {

    public static void insertAfter(Node current, int data) {

        if (current == null)
            return;

        Node newNode = new Node(data);

        newNode.next = current.next;
        current.next = newNode;
    }
}