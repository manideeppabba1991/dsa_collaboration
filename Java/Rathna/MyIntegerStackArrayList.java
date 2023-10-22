import java.util.ArrayList;
public class MyIntegerStackArrayList {
    private ArrayList<Integer> list;

    public MyIntegerStackArrayList() {
        list = new ArrayList<>();
    }
    public void push(int input) {
        list.add(input);
    }
    public int pop() {
        try {
            if(list.isEmpty())
                throw new Exception("myStack is empty");
            else
                return list.remove(list.size() - 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public int peek() {
        try {
            if(list.isEmpty())
                throw new Exception("myStack is empty");
            else
                return list.get(list.size() - 1);
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
