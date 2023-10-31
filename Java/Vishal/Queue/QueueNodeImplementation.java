package Queue;

public class QueueNodeImplementation {

    QueueNode head;
    QueueNode tail;

    int size;

    public QueueNodeImplementation() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean offer(int input) {
        boolean result = false;
        if(this.size == 0) {
            this.head = new QueueNode(input);
            this.tail = this.head;
            this.size++;
            result = true;
        } else {
            this.tail.next = new QueueNode(input);
            this.tail = this.tail.next;
            this.size++;
            result = true;
        }
        return result;
    }

    public QueueNode remove() {
        if(this.size == 0) {
            return null;
        }
        QueueNode newNode = this.head;
        this.head = this.head.next;
        newNode.next = null;
        this.size--;
        return newNode;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    public QueueNode peek() {
        if(this.size == 0) {
            return null;
        }
        return this.head;
    }

    public int getSize() {
        return this.size;
    }
}
