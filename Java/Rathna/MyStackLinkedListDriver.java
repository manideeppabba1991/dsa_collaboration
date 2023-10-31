public class MyStackLinkedListDriver {
    public static void main(String[] args) {
        MyStackUsingLinkedList myStackUsingLinkedList = new MyStackUsingLinkedList();
        myStackUsingLinkedList.push(10);
        myStackUsingLinkedList.push(20);
        myStackUsingLinkedList.push(30);
        myStackUsingLinkedList.push(40);
        myStackUsingLinkedList.push(50);
        System.out.println(myStackUsingLinkedList.toString());
        System.out.println(myStackUsingLinkedList.size());
        System.out.println(myStackUsingLinkedList.peek());
        System.out.println(myStackUsingLinkedList.pop());
        System.out.println(myStackUsingLinkedList.size());
        System.out.println(myStackUsingLinkedList.peek());
        System.out.println(myStackUsingLinkedList.pop());
        System.out.println(myStackUsingLinkedList.size());
        System.out.println(myStackUsingLinkedList.peek());
        System.out.println(myStackUsingLinkedList.pop());
        System.out.println(myStackUsingLinkedList.size());
        System.out.println(myStackUsingLinkedList.peek());
        System.out.println(myStackUsingLinkedList.pop());

        System.out.println(myStackUsingLinkedList.peek());
        System.out.println(myStackUsingLinkedList.size());
        System.out.println(myStackUsingLinkedList.isEmpty());
    }
}
