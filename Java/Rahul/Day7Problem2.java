//https://www.educative.io/courses/grokking-coding-interview-patterns-java/palindrome-linked-list
// time -- O(n)

public class PalindromeLinkedList {
    public static  void main(String[] args){

        LinkedListNode head = new LinkedListNode(10);
        LinkedListNode in2 = new LinkedListNode(20);
        LinkedListNode in3 = new LinkedListNode(30);
        LinkedListNode in4 = new LinkedListNode(40);
        LinkedListNode in41 = new LinkedListNode(50);
        LinkedListNode in5 = new LinkedListNode(40);
        LinkedListNode in6 = new LinkedListNode(30);
        LinkedListNode in7 = new LinkedListNode(20);
        LinkedListNode in8 = new LinkedListNode(10);
        head.next = in2;
        in2.next = in3;
        in3.next = in41;
        //in4.next = in41;
        in41.next = in5;
        in5.next = in6;
        in6.next = in7;
        in7.next = in8;
        in8.next = null;

        System.out.println(checkPalindrome(head));

    }

    private static boolean checkPalindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode fakeHead= head;
        int count =1;


        while(fast.next != null && fast.next.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        LinkedListNode rev;
        if(fast.next != null){
            rev= reverse(slow.next);
        }
        else{
            rev = reverse(slow);
        }
        while(count!=0){
            if(fakeHead.data != rev.data){
                return false;
            }
            fakeHead = fakeHead.next;
            rev = rev.next;
            count--;
        }
        return true;
    }
    private static LinkedListNode reverse(LinkedListNode in1) {

        LinkedListNode head = in1;
        LinkedListNode temp1 = null;

        while (head != null){
            LinkedListNode temp = head.next;
            head.next = temp1;
            temp1 = head;
            head = temp;
        }
        head = temp1;

        return head;
    }
}
