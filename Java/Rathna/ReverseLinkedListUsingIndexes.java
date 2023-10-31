public class ReverseLinkedListUsingIndexes {
    public static void main(String[] args) {
        Node p1 = new Node(1);
        Node p2 = new Node(2);
        Node p3 = new Node(3);
        Node p4 = new Node(4);
        Node p5 = new Node(5);
        Node p6 = new Node(6);
        Node p7 = new Node(7);

        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
        p4.setNext(p5);
        p5.setNext(p6);
        p6.setNext(p7);

        //Given Input: 1->2->3->4->5->6->7->null
        //Expected Output: 1->5->4->3->2->6->7->null
        int left = 2;
        int right = 5;
        System.out.println("Contents of LinkedList: " + p1);
        MyLinkedList finalResult = reverseLinkedListUsingGivenIndexes(p1, left, right);
        System.out.println("Final LinkedList result: " + finalResult);
    }

    private static MyLinkedList reverseLinkedListUsingGivenIndexes(Node head, int left, int right) {
        Node leftPosition = head;
        MyLinkedList result = new MyLinkedList();
        //Holding before left index nodes into result(LinkedList) and from left index into leftPosition node
        for (int i = 1; i < left; i++) {
            result.add(leftPosition.getData());
            leftPosition = leftPosition.getNext();
        }
        System.out.println("Contents of leftPosition: " + leftPosition);
        System.out.println("Contents of LinkedList initially: " + result.toStringFullDetails());

        Node nextOfRight = null;
        Node rightPosition = leftPosition;
        Node tempOfLeftPosition = leftPosition;
        //traversing from left index to right index in leftPosition node and capturing rightPosition node and nextToRight part into 2 separate nodes
        for (int i = left; i < right; i++) {
            tempOfLeftPosition = tempOfLeftPosition.getNext();
            rightPosition = tempOfLeftPosition;
            nextOfRight = rightPosition.getNext();
        }
        System.out.println("Contents of rightPosition: " + rightPosition);
        System.out.println("Contents of nextOfRight: " + nextOfRight);

        Node tempList = leftPosition;
        MyLinkedList linkedListInBetweenIndexes = new MyLinkedList();
        //capturing nodes in between left and right indexes
        while (tempList.getNext() != null) {
            if (tempList.getData() == rightPosition.getData()) {
                linkedListInBetweenIndexes.add(tempList.getData());
                break;
            } else {
                linkedListInBetweenIndexes.add(tempList.getData());
                tempList = tempList.getNext();
            }
        }
        System.out.println("Contents of linkedListInBetweenIndexes: " + linkedListInBetweenIndexes.toStringFullDetails());

        //reversing the nodes in between left and right indexes
        Node reversedInBetweenIndexes = linkedListInBetweenIndexes.reverse(linkedListInBetweenIndexes.getNode(0));
        System.out.println("Contents of reversedInBetweenIndexes: " + reversedInBetweenIndexes.toString());

        //joining before left index nodes with reversed in between nodes
        result = joinLeftAndRight(result, reversedInBetweenIndexes);

        //joining above resultant nodes with nextOfRight nodes
        result = joinLeftAndRight(result, nextOfRight);

        System.out.println("Resultant linkedList: " + result.toStringFullDetails());
        return result;
    }

    //Method to add rightSide nodes param into leftSide linkedList
    private static MyLinkedList joinLeftAndRight(MyLinkedList leftSide, Node rightSide) {
        while(rightSide != null) {
            leftSide.add(rightSide.getData());
            rightSide = rightSide.getNext();
        }
        return leftSide;
    }
}
