public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList(Node head) {
        this.head = head;
        this.size = 0;
    }

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (this.size == 0 || head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
        } else if (index > 0 && index < size) {
            Node current = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            previous.setNext(current.getNext());
        } else {
            throw new IndexOutOfBoundsException();
        }
        size--;
    }

    public int size() {
        return size;
    }

    public Integer get(int index) {
        if (index == 0) {
            return head.getData();
        }
        if (index > 0 && index < size) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        } else {
            throw new IndexOutOfBoundsException();
        }

    }
}
