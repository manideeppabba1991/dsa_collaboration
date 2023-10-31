
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
        System.out.println("Middle of the LinkedList before removing: " + myLinkedList.getMiddle());
        System.out.println("Contents of LinkedList before removing: " + myLinkedList.toString());
        myLinkedList.remove(3);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(3));
        System.out.println("Middle of the LinkedList after removing: " + myLinkedList.getMiddle());
        System.out.println("Contents of LinkedList after removing: " + myLinkedList.toString());
        System.out.println("Is the given LinkedList cyclic? : " + myLinkedList.detectCycle());

        // Creating cyclic nodes first
        Node n1 = new Node(5);
        Node n2 = new Node(15);
        Node n3 = new Node(25);
        Node n4 = new Node(35);
        Node n5 = new Node(45);
        Node n6 = new Node(55);
        Node n7 = new Node(65);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n4);

        // Assigning first node to head of linkedList and thus creating cyclic linkedList
        MyLinkedList cyclicLinkedList = new MyLinkedList(n1);
        System.out.println("Is the new LinkedList cyclic? : " + cyclicLinkedList.detectCycle());
        //Day 6 - Problem 1
        System.out.println("Start of the cyclic LinkedList is: " + cyclicLinkedList.detectStartOfCycle());

        //Day 6 - Problem 2
        Node m1 = new Node(4);
        Node m2 = new Node(8);
        Node m3 = new Node(12);
        Node m4 = new Node(16);
        Node m5 = new Node(20);

        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);

        System.out.println("Contents of LinkedList before reversing: " + m1.toString());
        System.out.println("Reverse of LinkedList: " + myLinkedList.reverse(m1));

    }
}
