//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
// rotate alternate of k pairs

class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode forLength = head;
        while(forLength != null){
            length++;
            forLength = forLength.next;
        }

        int groups = length/k;
        ListNode cur = head;

        ListNode endPrevList = null;
        int counter =0;

        while(groups>0){
            ListNode endCurList = cur;
            if(counter%2==0){
                int dummyK = k; // 2nd loop val =2
                ListNode prev = null;
                //1-- // 3--

                while(dummyK>0){
                    ListNode temp = cur.next; // 5
                    cur.next = prev; // 2-1- null
                    prev = cur; //
                    cur = temp; // 3--// 4-5
                    dummyK--; //
                }
                endCurList.next = cur; //
                if(endPrevList== null){
                    head = prev;
                }else{
                    endPrevList.next = prev;
                }

                endPrevList = endCurList;

            }else{
                int dummyK = k;
                while(dummyK>0){
                    endPrevList = cur;
                    cur = cur.next;
                    dummyK--;
                }
            }
            groups--;
            counter++;
        }
        return head;
    }
}
