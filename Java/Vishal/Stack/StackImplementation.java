package Stack;

public class StackImplementation {

    StackNode tail;
    int size;

    public StackImplementation(){
        this.tail = null;
        this.size = 0;
    }

    public void push(int input) {

        if(this.size == 0) {
            this.tail = new StackNode(input);
            this.size++;
        } else {
            StackNode currentNode = this.tail;
            this.tail = new StackNode(input);
            this.tail.prev = currentNode;
            this.size++;
        }
    }

    public StackNode pop(){
        if(this.size == 0) {
            return null;
        } else {
            StackNode newStack = this.tail;
            this.tail = this.tail.prev;
            newStack.prev = null;
            this.size--;
            return newStack;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public StackNode peek() {
        if(this.size == 0) {
            return null;
        }
        return this.tail;
    }
}
