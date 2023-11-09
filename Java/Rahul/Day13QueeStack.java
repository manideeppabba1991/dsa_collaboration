import java.util.Stack;

public class MyQueeStack {

    public Stack<Integer> queeStack;

    public int size;

    public int lastElement;

    public MyQueeStack(){
        queeStack = new Stack<>();
        size =0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Integer value){
        if(size == 0)
            lastElement = value;

        queeStack.add(value);
        size++;
    }

    public Integer element() throws Exception {
        if(size == 0)
            throw new Exception("empty quee");

        return lastElement;
    }

    public Integer peek()  {
        if(size == 0)
            return null;

        return lastElement;
    }

    public Integer poll()  {
        if(size == 0)
            return null;

        Stack<Integer> temp = new Stack<>();

        while(!queeStack.isEmpty()){
            temp.add(queeStack.pop());
        }
        int op = temp.pop();
        lastElement =temp.peek();
        while(!temp.isEmpty()){
            queeStack.add(temp.pop());
        }
        size--;
        return op;
    }

    public Integer remove() throws Exception {
        if(size == 0)
            throw new Exception("empty quee");

        Stack<Integer> temp = new Stack<>();

        while(!queeStack.isEmpty()){
            temp.add(queeStack.pop());
        }
        int op = temp.pop();
        while(!temp.isEmpty()){
            queeStack.add(temp.pop());
        }
        size--;
        return op;
    }
}
