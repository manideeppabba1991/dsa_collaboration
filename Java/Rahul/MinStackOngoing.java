import java.util.*;

public class MinStack {
    public int min;
    public int size;
    public List<Integer> minInAr;
    public Stack<Integer> input;
    public MinStack() {
        // Write your code here
        input = new Stack<Integer>();
        size = 0;
        minInAr = new ArrayList<Integer>();
    }

    // Pop() removes and returns value from minStack
    public int pop() {

        if(size ==0)
            return -1;
        size--;
        return input.pop();
    }

    // Pushes values into MinStack
    public void push(Integer value) {
        if(size == 0)
            min = value;

        if(value<min)
            min = value;

        input.push(value);
        size++;
        minInAr.set(size,min);
    }

    // returns minimum value in O(1)
    public int minNumber() {

        if(size ==0)
            return -1;

        return minInAr.get(size);
    }
}
