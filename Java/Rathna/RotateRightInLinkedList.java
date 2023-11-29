import java.util.List;

public class RotateRightInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode n1 = new ListNode(20);
        ListNode n2 = new ListNode(30);
        ListNode n3 = new ListNode(40);
        ListNode n4 = new ListNode(50);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println(head);
        int kTimes = 5;
        /*ListNode rotatedList = rotateRightKTimes(head, kTimes);
        System.out.println(rotatedList.toString());*/
        ListNode rotatedList = rotateKTimesRight(head, kTimes);
        System.out.println(rotatedList.toString());
    }

    private static ListNode rotateRightKTimes(ListNode head, int kTimes) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        if(size == 0) {
            return head;
        }
        current = head;
        ListNode previous = null;
        for (int i = 1; i <= kTimes % size; i++) { //TC = O(n * k)
            while (current != null) {
                if (current.next == null) {
                    previous.next = current.next;
                    current.next = head;
                    head = current;
                    break;
                }
                previous = current;
                current = current.next;
            }
        }
        return head;
    }

    private static ListNode rotateKTimesRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        ListNode last = null;
        int size = 0; // 1->2->3->4->5->null
        while(temp != null) {
           last = temp;
           size++;
           temp = temp.next;
        }
        if(k % size == 0) {
            return head;
        }

        // last = 5->null
        // k = 3
        int splitNode = size - (k % size);
        // splitNode = (5-3) % 5 = 2

        ListNode current = head;
        ListNode previous = null;
        // head = 1->2->3->4->5->null
        for(int i = 1; i < splitNode; i++) {
            current = current.next;
        }
        ListNode nextNode = current.next;
        current.next = null;
        last.next = head;
        head = nextNode;

        return head;
    }
}
