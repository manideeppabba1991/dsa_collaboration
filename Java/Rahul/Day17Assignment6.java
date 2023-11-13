//https://leetcode.com/problems/reorder-list/description/
// TC = o(n), space = constant 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow =head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next; // setting rght part
        ListNode revRight =null;
        slow.next = null;

        //reversng right part
        while(right != null){
            ListNode temp = right.next;
            right.next = revRight;
            revRight =right;
            right = temp;
        }

        //reordering
        ListNode cur = head;
        while(revRight !=null){
            ListNode tempHead = cur.next;
            ListNode tempRev = revRight.next;
            cur.next = revRight;
            cur.next.next = tempHead;
            revRight = tempRev;
            cur = tempHead;
        }
    }
}
