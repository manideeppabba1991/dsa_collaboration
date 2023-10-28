public class CheckPalindromeInLinkedList {
    public static void main(String[] args) {

        Node p1 = new Node(1);
        Node p2 = new Node(2);
        Node p3 = new Node(3);
        Node p4 = new Node(4);
        Node p5 = new Node(3);
        Node p6 = new Node(2);
        Node p7 = new Node(1);

        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
        p4.setNext(p5);
        p5.setNext(p6);
        p6.setNext(p7);

        System.out.println("Contents of LinkedList: " + p1.toString());
        System.out.println("Is the LinkedList Palindrome?: " + checkPalindromeInLinkedList(p1));

    }

    // Day 7 - Problem 2
    public static boolean checkPalindromeInLinkedList(Node headNode) {
        Node temp = headNode;
        int length = 1;
        while(temp.getNext() != null) {
            temp = temp.getNext();
            length++;
        }
        Node slow = headNode;
        Node fast = headNode;
        Node reverse = new Node(0);
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(fast.getNext() == null) {
                reverse = reverse(slow);
                System.out.println("Contents of reverse LinkedList:" + reverse.toString());
            }
        }
        int mid = length/2;
        System.out.println("Mid value: " + mid);
        System.out.println("Contents of Head after reversing: " + headNode.toString());
        System.out.println("Contents of reverse LinkedList:" + reverse.toString());
        Node tempHeadNode = headNode;
        Node tempReverseNode = reverse;
        for(int i = 0; i <= mid; i++) {
            if(tempHeadNode.getData() != tempReverseNode.getData()) {
                return false;
            } else {
                tempHeadNode = tempHeadNode.getNext();
                tempReverseNode = tempReverseNode.getNext();
            }
        }
        return true;
    }

    public static Node reverse(Node head) {
        Node previous = null;
        Node current = head;
        while(current != null) {
            Node temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }
        return previous;
    }
}
