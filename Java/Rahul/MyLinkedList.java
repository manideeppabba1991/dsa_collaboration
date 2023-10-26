public class MyLinkedList {
    public class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
        public Node getNext() {
            return next;
        }
    }

    public int size;

    public Node head;
    public Node tail;

    public MyLinkedList(){

    }

    public void add(int in){
        if(size ==0){
           this.head =  new Node(in);
           this.tail = this.head;
        }
        else{
            Node n = new Node(in);
            n.previous = tail;
            tail.next = n;
            tail =n;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public boolean find(int in){
        Node nw = head;
        int left =0;
        while(left<size){
            if(nw.data ==in){
                return true;
            }
            nw = nw.next;
            left++;
        }
        return false;
    }

    public boolean remove(int val){
        if(size ==0)
            return false;
        if(size ==1 && head.data == val){
            head = null;
            tail = null;
            size--;
            return true;
        }

        Node nw = head;
        while(nw.next !=null){
            if(nw.data ==val ){
                nw.next.previous = nw.previous;
                nw.previous.next = nw.next;
                size--;
                return true;
            }
            nw = nw.next;
        }
        return false;
    }

    public int get(int index){
        if(index>size)
            return -1;
        int lp = 0;
        Node nw = head;
        while(lp > size){
            if(lp == index){
                return nw.data;
            }
            nw = nw.next;
            lp++;
        }
        return -1;
    }

}
