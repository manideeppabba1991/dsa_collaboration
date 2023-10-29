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

    public Node getNode(int index) {
        if (index == 0) {
            return head;
        }
        if (index > 0 && index < size) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Integer getMiddle() {
        Node slow = new Node(0);
        Node fast = new Node(0);
        if(head.getNext() != null) {
            slow = head;
            fast = head;
        }
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getData();
    }

    public boolean detectCycle() {
        Node slow = head;
        Node fast = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    //Day 6 - Problem 1
    public Integer detectStartOfCycle() {
        Node slow = head;
        Node fast = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                Node start = head;
                while(slow.getNext() != null) {
                    if(start == slow) {
                        return slow.getData();
                    }
                    start = start.getNext();
                    slow = slow.getNext();
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        Node temp = head;
        String result = "";
        for(int i = 0; i < size(); i++) {
            result += String.valueOf(temp.getData()) + " ";
            temp = temp.getNext();
        }

        return "MyLinkedList{" +
                "contents of linkedList=" + result +
                ", size=" + size +
                '}';
    }

    public String toStringFullDetails() {
        return "MyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    //Day 6 - Problem 2
    public Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        while(current != null) {
            Node temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }
        return previous;
    }
}
