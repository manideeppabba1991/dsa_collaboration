public class ReverseLinkedList {
    public static  void main(String[] args){

        LinkedListNode head = new LinkedListNode(10);
        LinkedListNode in2 = new LinkedListNode(20);
        LinkedListNode in3 = new LinkedListNode(30);
        LinkedListNode in4 = new LinkedListNode(40);
        LinkedListNode in5 = new LinkedListNode(50);
        LinkedListNode in6 = new LinkedListNode(60);
        LinkedListNode in7 = new LinkedListNode(70);
        LinkedListNode in8 = new LinkedListNode(80);
        head.next = in2;
        in2.next = in3;
        in3.next = in4;
        in4.next = in5;
        in5.next = in6;
        in6.next = in7;
        in7.next = in8;
        in8.next = null;


        LinkedListNode out = reverseLinkedList(head);
        System.out.println(out.data);

    }
    private static LinkedListNode reverseLinkedList(LinkedListNode in1) {

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
