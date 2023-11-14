public class ReorderList {
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
        System.out.println("Before reorder: " + head);
        reorderList(head);
        System.out.println("After reorder: " + head);
    }

    private static void reorderList(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return;
        }

        //define slow and fast pointers
        ListNode slow = head, fast = head, prevMid = null;

        //slow points to the middle node in the list
        while (fast.next != null && fast.next.next != null) {
            prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //break the list
        prevMid.next = null;

        //reverse the second half of the list
        ListNode p1 = head, p2 = reverse(slow);

        //reorder the list
        while (p1 != null && p2 != null) { //TC = O(n) and SC = O(1)
            ListNode nextNodeOfP1 = p1.next, nextNodeOfP2 = p2.next;
            p1.next = p2;
            p2.next = nextNodeOfP1 != null ? nextNodeOfP1 : nextNodeOfP2;

            p1 = nextNodeOfP1;
            p2 = nextNodeOfP2;
        }

    }

    private static ListNode reverse(ListNode head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        //reversing list and returning previous node
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }
}
