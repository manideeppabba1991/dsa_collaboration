package MinStack;
public class MinStackImplementation {

    MinStackNode tail;
    int size;

    int minValue;

    public MinStackImplementation() {
        this.tail = null;
        this.size = 0;
    }

    public void push(int input) {

        if(this.size == 0) {
            this.tail = new MinStackNode(input);
            minValue = input;
            this.size++;
        } else {
            MinStackNode currentNode = this.tail;
            this.tail = new MinStackNode(input);
            this.tail.prev = currentNode;
            if(input < minValue) {
                minValue = input;
            }
            this.size++;
        }
    }

    public int getMinValue() {
        return this.minValue;
    }
}
