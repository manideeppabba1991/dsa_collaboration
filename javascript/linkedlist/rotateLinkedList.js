const rotateLinkedList = (head, k) => {
    if(!head || !head.next || !k) return head;
    let curr = head;
    let size = 0;
    let lastNode = null;

    // 1- 2 -3 - null , 4-5 - 1 - 2 -3 -null , k = 2 => 4 - 5 - 1- 2- 3
    
    // Get Size
    while(curr !=  null) {
        size++;
        if(curr.next === null) {
            lastNode = curr; // 5
        }
        curr = curr.next;
    }

    if(k % size === 0) return head;

    // 
    let traverseLength = size - (k % size); // 5 - 2 = 3

    curr = head;
    let newHead;
    
    // 1- 2- 3 -4 - 5 - null
    while( traverseLength > 1) {
        traverseLength--;
        curr = curr.next; // 3
    }

    newHead = curr.next; // 4

    lastNode.next = head; // 4 - 5 - 1 - 2- 3 - null
    curr.next = null;
    head = newHead;

    return head;
}