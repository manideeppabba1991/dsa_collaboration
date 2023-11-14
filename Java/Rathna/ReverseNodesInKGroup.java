public class ReverseNodesInKGroup {
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
        ListNode result = reverseKGroup(head, k);
        System.out.println("After reversing: " + result);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        //base case
        if (k == 1 || head.next == null) {
            return head;
        }

        //count total number of nodes
        ListNode current = head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        //define previous and current pointers
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode previous = dummy;
        current = head;
        ListNode next = null;

        //reverse the list in k groups
        while (size >= k) { // TC = O(n) and SC = O(1)
            current = previous.next;
            next = current.next;

            for (int i = 1; i < k; i++) {
                current.next = next.next;
                next.next = previous.next;
                previous.next = next;
                next = current.next;
            }
            previous = current;
            size = size - k;
        }

        //return the head
        return dummy.next;
    }
}
