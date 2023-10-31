package MyLinkedList;

public class ReverseLinkedList {

    public Node reverseLinkedList(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node	temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        printValues(prev);
        return prev;
    }

    public void printValues(Node node) {

        while (node.next != null) {
            System.out.println(node.input);
            node = node.next;
        }
        System.out.println(node.input);
    }

    public void reverseLinkedFromIndex(int left, int right, Node head) {

        Node dummyNode = new Node();
        dummyNode.input = 0;

        dummyNode.next = head;

        Node leftPart = dummyNode;
        Node currentNode = head;
        int curIndex= 0;

        while (curIndex < left -1 ) {
            leftPart = leftPart.next;
            currentNode = currentNode.next;
            curIndex++;
        }

        Node tempHead = currentNode;

        Node prev = null;
        int counter = 0;
        while(counter <= right-left) {
            Node nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
            counter++;
        }

        leftPart.next = prev;
        tempHead.next = currentNode;

        printValues(dummyNode.next);
    }

    public Boolean isPalindrome(Node head) {
        boolean result = false;
        Node oldHead = head;
        Node prev = null;
        Node currentNode = head;
        while(currentNode != null) {
            Node tempNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = tempNode;
        }
        printValues(prev);
        while(oldHead.next != null) {
            if(oldHead.input == prev.input) {
                result = true;
            } else {
                result = false;
                break;
            }
            oldHead = oldHead.next;
            prev = prev.next;
        }
        return result;
    }

    public Node reverseLinkedListInBetweenNodes(Node head, Node tail) {

        Node prev = tail;
        Node curr = head;

        while (curr != null) {
            Node	temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        printValues(prev);
        return prev;
    }


}
