public class MinStack {
    Node head;
    Node minNode;
    int size;

    public MinStack() {
        head = null;
        minNode = null;
        size = 0;
    }

    public void push(int data) {
        if (this.size == 0 || head == null) {
            this.head = new Node(data);
            this.minNode = new Node(data);
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        this.size++;
        Node tempNewNode = newNode;
        if(tempNewNode.data < minNode.data) {
            Node temp = minNode;
            tempNewNode.next = minNode;
            minNode = tempNewNode;
        } else {
            minNode.next = tempNewNode;
        }
    }

    public Node pop() {
        if(size == 0 || head == null) {
            return null;
        }
        Node result = this.head;
        this.head = this.head.next;
        size--;
        if(result.data == minNode.data) {
            minNode = minNode.next;
        }
        return result;
    }

    public Node peek() {
        if (size == 0 || head == null)
            return null;

        return head;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public int minNumber() {
        return minNode.data;
    }

    @Override
    public String toString() {
        return "MinStack{" +
                "head=" + head +
                ", minNode=" + minNode +
                ", size=" + size +
                '}';
    }

    public String toStringFullDetails() {
        return "MinStack{" +
                "head=" + head.toStringFullDetails() +
                ", minNode=" + minNode.toStringFullDetails() +
                ", size=" + size +
                '}';
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

        public String toStringFullDetails() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
