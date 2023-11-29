// what is queue? 
// FIFO.
// BFS

// LinkedList - Singly & Doubly, ArrayList.
// ArrayList - Capacity reinitiated when shirinking and expanding 
// Linked list - Just head is required 

interface LinkedListNode<T> {
    value: <T>,
    next: LinkedListNode
}

class Queue {

    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add/insert   1 -> 2 -> 3
    add(v) { // t: O(1), // S: (1)
        if(this.head == null) {
            this.head = new LinkedListNode(v);
            this.tail = this.head;
        }
        this.tail.next = new LinkedListNode(v);
        this.tail = this.tail.next;
        this.size++;
    } 

    // remove/pop
    remove() { // T: O(1), S: O(1)
        if(this.head == null) return null;
        const returnValue = this.head;
        this.head = this.head.next;
        this.size--;
        returnValue.next = null; 
        return returnValue;
    }

    
    // isEmpty

    isEmpty() {
        return this.size==0;
    }

    // peek
    peek() {
        if(this.isEmpty()) return null;
        return this.head;
    }

    // size
    size() {
        return this.size();
    } 
}