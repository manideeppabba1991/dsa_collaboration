public class SwictNodeLinked {
    public static void main(String[] args){

        LinkedListNode out1 = new LinkedListNode(1);
        LinkedListNode out2 = new LinkedListNode(2);
        LinkedListNode out3 = new LinkedListNode(3);
        LinkedListNode out4 = new LinkedListNode(4);
        LinkedListNode out5 = new LinkedListNode(5);
        LinkedListNode out6 = new LinkedListNode(6);
        out1.next = out2;
        out2.next = out3;
        out3.next = out4;
        out4.next = out5;
        out5.next = out6;
        out6.next = null;

        LinkedListNode forPrint = out1;
        System.out.println("input");
        while (forPrint != null){
            System.out.print(" "+forPrint.data);
            forPrint = forPrint.next;
        }
        System.out.println("");

        /*LinkedListNode out =  swapinLinked(out1, out2,out5);

        System.out.println("output");
        while (out != null){
            System.out.print(" "+out.data);
            out = out.next;
        }*/
        System.out.println("");
        LinkedListNode outVal =  swapinLinkedValue(out1, out2,out5);
        System.out.println("output 2nd");
        while (outVal != null){
            System.out.print(" "+outVal.data);
            outVal = outVal.next;
        }

    }

    //did just for fun
    private static LinkedListNode swapinLinkedValue(LinkedListNode head, LinkedListNode node1, LinkedListNode node2) {
        LinkedListNode cur = head;
        int node1val = node1.data;
        int node2val = node2.data;

        while(cur !=null){
            if(cur == node1){
                cur.data = node2val;
            }else if(cur == node2){
                cur.data = node1val;
            }
            cur = cur.next;
        }
        return head;
    }

    //actaul solution
    //TC = o(n), SC = O(1)
    private static LinkedListNode swapinLinked(LinkedListNode head, LinkedListNode node1, LinkedListNode node2){

        LinkedListNode cur = head;
        LinkedListNode prev = null;
        LinkedListNode prevPart = null;
        LinkedListNode prevNode = null;
        LinkedListNode midPart = null;
        LinkedListNode midEnd = null;
        LinkedListNode lastPart = null;
        LinkedListNode lastNode = null;

        while(cur != null){
            if(cur == node1 || cur == node2){
                if(prevPart == null & midPart == null){
                    prevPart = prev;
                    midPart = cur.next;
                    prevNode = cur;

                }else{
                    lastPart = cur.next;
                    lastNode = cur;
                }
            }
            if(midPart != null && midPart != cur.next && lastNode == null)
                midEnd = cur;

            prev = cur;
            cur =cur.next;
        }

        prevNode.next = lastPart;

        if(midEnd == midPart)
            midPart.next = prevNode;
        else
            midEnd.next = prevNode;

        lastNode.next = midPart;

        if(prevPart == null)
            return lastNode;

        prevPart.next = lastNode;

        return head;
    }

}
