// I used two while loops but as the inside while only runs once i feel complexity is 2n at max so o(n)
//space is constant as we are using only pointers
//https://www.educative.io/courses/grokking-coding-interview-patterns-java/reverse-linked-list-ii
public class Day7problem1 {
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


        LinkedListNode out = reverseLinkListIndices(1,8,head);
        System.out.println(out.data);

    }
    public static LinkedListNode reverseLinkListIndices(int left,int right, LinkedListNode head){
        LinkedListNode cur = head;
        LinkedListNode leftPoint = null; //pointer for left part if there is one
        
        LinkedListNode prev = null; // parama for reversing linked list
        LinkedListNode temp = null; // param for storing next address while changing next during reversal
        int counter = 1; // starting index at 1
        while(cur != null){
            if(counter >right){  // if counter increased more than count
                LinkedListNode previo = prev;  //setting this for pointer for end element of reversed
                while(previo.next != null){
                    previo = previo.next;
                }
                previo.next = cur; // seeting end of previous to current 
                if(leftPoint == null){  // checking if left pointer = null and returning previous
                    head =prev;
                    return head;
                }
                leftPoint.next =prev; //in left pointer != null setiing the next to reversed linked liist
                return head; // returning head
            }
            else if(counter >= left){ // reversing the list when it didn't reach the right part
                temp = cur.next; 
                cur.next = prev;
                prev = cur;
                cur = temp;

            }else{
                leftPoint = cur; // setting the left point to currecnt before loop/cointer reached left index
                cur =cur.next;
            }
            counter++;
        }
        head = prev;
        return head;
    }
}
