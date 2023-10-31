public class MyQueueUsingLinkedList {
    Node head;
    Node tail;
    int size;

    public MyQueueUsingLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (size == 0 || (head == null && tail == null)) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Node remove() {
        if (size == 0 || (head == null && tail == null)) {
            return null;
        }
        Node result = head;
        head = head.next;
        size--;
        if (size == 0 || head == null) {
            tail = null;
        }
        return result;
    }

    public Node peek() {
        if (size == 0 || (head == null && tail == null)) {
            return null;
        }
        return head;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
