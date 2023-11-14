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
        int kTimes = 6;
        ListNode rotatedList = rotateRightKTimes(head, kTimes);
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
        for (int i = 1; i <= kTimes % size; i++) {
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
}
