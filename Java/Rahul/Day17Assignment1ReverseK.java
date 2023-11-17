//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
//TC = o(n) , SC = O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode forLength = head;
        int length = 0;

        while(forLength != null){
            length++;
            forLength = forLength.next;
        }

        int group = length/k;

        ListNode cur = head;
        ListNode endPrev = null;

        while(group > 0){
            int dummyK = k;
            ListNode prev = null;

            ListNode curEnd = cur;
            while(dummyK >0){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
                dummyK--;
            }

            curEnd.next = cur;
            if(endPrev == null){
                head = prev;
            }else{
                endPrev.next = prev;
            }
            endPrev = curEnd;
            group--;
        }
        return head;
    }
}
