function findMiddle(head) {
    let tortoise = head;
    let hare = head;

    // 1 -> 2 -> 3 -> 4 -> 5 -> null;

    while(hare.next && hare.next.next) {
        tortoise = tortoise.next;
        hare = hare.next.next;
    }
    return tortoise;
}