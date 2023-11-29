public class RotateRight {
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
        System.out.println("Before reversing: " + head);
        int k = 2;
        ListNode result = rotateList(head, k);
        System.out.println("After: " + result);
    }

    private static ListNode rotateList(ListNode head, int k) {
        //base condition
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        //find size of the linkedList
        ListNode current = head;
        int size = 0;
        ListNode last = null;
        while(current != null) { // TC = O(n + m) ==> O(n) and SC = O(1)
            last = current;
            size = size + 1;
            current = current.next;
        }

        //if k is multiple of size, return head
        if(k % size == 0) {
            return head;
        }

        // 1->2->3->4->5
        //k = 2
        //5 - (2 % 5)
        // break = 3
        int breakpoint = size - (k % size);

        current = head;
        for(int i = 1; i < breakpoint; i++) {
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;
        last.next = head;
        head = newHead;

        return head;

    }
}
