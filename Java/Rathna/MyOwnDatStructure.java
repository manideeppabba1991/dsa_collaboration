public class MyOwnDatStructure {
    public static void main(String[] args) {
        MyIntegerStackArrayList myStackArrayList = new MyIntegerStackArrayList();
        myStackArrayList.push(10);
        myStackArrayList.push(20);
        myStackArrayList.push(30);
        System.out.println("Viewing top element: " + myStackArrayList.peek());
        System.out.println("Size of myStack before removing top element: " + myStackArrayList.size());
        System.out.println("Removing top element: " + myStackArrayList.pop());
        System.out.println("Size of myStack after removing top element: " + myStackArrayList.size());
        System.out.println("Viewing latest top element after pop: " + myStackArrayList.peek());
        System.out.println("Is the stack empty: " + myStackArrayList.empty());
        System.out.println("Size of myStack: " + myStackArrayList.size());



        MyIntegerQueueLinkedList myIntegerQueueLinkedList = new MyIntegerQueueLinkedList();
        myIntegerQueueLinkedList.offer(10);
        myIntegerQueueLinkedList.offer(20);
        myIntegerQueueLinkedList.offer(30);
        System.out.println("Viewing first element: " + myIntegerQueueLinkedList.peek());
        System.out.println("Size of myQueue before removing first element: " + myIntegerQueueLinkedList.size());
        System.out.println("Removing first element: " + myIntegerQueueLinkedList.remove());
        System.out.println("Size of myQueue after removing first element: " + myIntegerQueueLinkedList.size());
        System.out.println("Viewing latest first element after pop: " + myIntegerQueueLinkedList.peek());
        System.out.println("Is the Queue empty: " + myIntegerQueueLinkedList.empty());
        System.out.println("Size of myQueue: " + myIntegerQueueLinkedList.size());
    }
}
