// https://leetcode.com/problems/rotate-list/
// TC = O(n^2), space = constant

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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur = head;
        int counter = 0;
        while(cur != null){
            counter++;
            cur = cur.next;
        }
        if(counter == 0)
            return head;
            
        int traverse = k%counter;

        for(int i=0;i<traverse;i++){
            head =rotate(head);
        }
        return head;
    }
    public ListNode rotate(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            if(cur.next == null && prev !=null){
                prev.next = cur.next;
                cur.next = head;  
                head = cur;
                break;  
            }
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
