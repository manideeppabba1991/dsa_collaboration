import java.util.LinkedList;

public class Application {

    public static void main(String[] args) {

        LinkedListNode linkedListNode = new LinkedListNode();

        linkedListNode.insert(5);
        linkedListNode.insert(12);
        linkedListNode.printValues();

        linkedListNode.insertAtStart(25);
        linkedListNode.printValues();

        linkedListNode.insertAtIndex(2, 30); //25,5,12
        linkedListNode.printValues(); //25,5,30,12
        linkedListNode.insertAtIndex(1, 35);//25,35,5,30,12
        linkedListNode.printValues();

        linkedListNode.findAtIndex(linkedListNode, 2);
        linkedListNode.findWithValue(linkedListNode, 12);
        linkedListNode.findWithValue(linkedListNode, 5);
        linkedListNode.findWithValue(linkedListNode, 99);

    }
}
