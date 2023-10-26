
public class MyLinkedListDriver {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.add(40);
        myLinkedList.add(50);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(4));
        System.out.println("Size of myLinkedList before removing: " + myLinkedList.size());
        myLinkedList.remove(0);
        System.out.println("Size of myLinkedList after removing: " + myLinkedList.size());
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));
    }
}
