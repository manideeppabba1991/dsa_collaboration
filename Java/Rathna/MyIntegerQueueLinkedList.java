import java.util.LinkedList;

public class MyIntegerQueueLinkedList {
    private LinkedList<Integer> list;

    public MyIntegerQueueLinkedList() {
        this.list = new LinkedList<>();
    }

    public void offer(int input) {
        list.add(input);
    }
    public int remove() {
        try {
            if(list.isEmpty())
                throw new Exception("myQueue is empty");
            else
                return list.remove(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public int peek() {
        try {
            if(list.isEmpty())
                throw new Exception("myStack is empty");
            else
                return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean empty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

}
