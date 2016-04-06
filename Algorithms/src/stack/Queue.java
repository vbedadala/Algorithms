package stack;

public class Queue<T> {

    private Node<T> head;

    public static class Node<T> {
        public T data;
        public Node<T> next;
    }

    // insert at last
    public void insert(T data) {
        if (head == null) {
            Node<T> node = new Node<T>();
            node.data = data;
            head = node;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node<T> node = new Node<T>();
        node.data = data;
        temp.next = node;
        return;
    }

    // delete front
    public T delete() {
        if (head == null) {
            // nothing to delete
            return null;
        }
        Node<T> temp = head;
        head = head.next;
        return temp.data;
    }

    public Queue() {

    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

}
