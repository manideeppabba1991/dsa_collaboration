public class MyQueueLinkedListDriver {
    public static void main(String[] args) {
        MyQueueUsingLinkedList myQueueUsingLinkedList = new MyQueueUsingLinkedList();
        myQueueUsingLinkedList.add(10);
        myQueueUsingLinkedList.add(20);
        myQueueUsingLinkedList.add(30);
        myQueueUsingLinkedList.add(40);
        myQueueUsingLinkedList.add(50);
        System.out.println(myQueueUsingLinkedList.size());
        System.out.println(myQueueUsingLinkedList.peek());
        System.out.println(myQueueUsingLinkedList.remove());
        System.out.println(myQueueUsingLinkedList.peek());
        System.out.println(myQueueUsingLinkedList.size());
        System.out.println(myQueueUsingLinkedList.isEmpty());
    }
}
