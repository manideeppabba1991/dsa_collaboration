package MinStack;

public class MinStackImplementation {

    MinStackNode tail;
    int size;

    MinStackNode minStack;

    int minValue;

    public MinStackImplementation() {
        this.tail = null;
        this.size = 0;
        this.minStack = null;
    }

    public void push(int input) {

        if(this.size == 0) {
            this.tail = new MinStackNode(input);
            minValue = input;
            this.minStack = new MinStackNode(input);
            this.size++;
        } else {
            MinStackNode currentNode = this.tail;
            this.tail = new MinStackNode(input);
            this.tail.prev = currentNode;
            if(input < minValue) {
                minValue = input;
            }
            MinStackNode currentMinStackNode = this.minStack;
            this.minStack = new MinStackNode(minValue);
            this.minStack.prev = currentMinStackNode;
            this.size++;
        }
    }

    public MinStackNode pop(){
        if(this.size == 0) {
            return null;
        } else {
            MinStackNode newStack = this.tail;
            this.tail = this.tail.prev;
            newStack.prev = null;

            MinStackNode newMinStack = this.minStack;
            this.minStack = this.minStack.prev;
            newMinStack.prev = null;
            this.size--;
            return newStack;
        }
    }



    public int getMinValue() {
        return this.minStack.value;
    }
}
