package MinStack;

public class MinStackNode {

    int value;
    MinStackNode prev;

    MinStackNode(int v) {
        this.value = v;
        this.prev = null;
    }
}
