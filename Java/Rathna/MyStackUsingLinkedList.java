public class MyStackUsingLinkedList {
    Node head;
    int size;

    public MyStackUsingLinkedList(Node head) {
        this.head = head;
        this.size = 0;
    }

    public MyStackUsingLinkedList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public String toString() {
        return "MyStackUsingLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    public void push(int data) {
        if (this.size == 0 || head == null) {
            this.head = new Node(data);
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        this.size++;
    }

    public Node pop() {
        if (size == 0 || head == null)
            return null;

        Node result = this.head;
        this.head = this.head.next;
        this.size--;
        return result;
    }

    public Node peek() {
        if (size == 0 || head == null)
            return null;

        return this.head;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
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
