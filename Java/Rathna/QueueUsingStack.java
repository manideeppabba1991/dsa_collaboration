import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> insertionStack;
    private Stack<Integer> retrievalStack;

    public QueueUsingStack() {
        insertionStack = new Stack<>();
        retrievalStack = new Stack<>();
    }

    public void add(int element) {
        insertionStack.push(element);
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (retrievalStack.isEmpty()) {
            while (!insertionStack.isEmpty()) {
                retrievalStack.push(insertionStack.pop());
            }
        }
        return retrievalStack.pop();
    }

    public int element() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (retrievalStack.isEmpty()) {
            while (!insertionStack.isEmpty()) {
                retrievalStack.push(insertionStack.pop());
            }
        }
        return retrievalStack.peek();
    }

    public boolean isEmpty() {
        return insertionStack.isEmpty() && retrievalStack.isEmpty();
    }

    public int size() {
        return insertionStack.size() + retrievalStack.size();
    }

    @Override
    public String toString() {
        return "QueueUsingStack{" +
                "insertionStack=" + insertionStack +
                ", retrievalStack=" + retrievalStack +
                '}';
    }

    public static void main(String[] args) {

        QueueUsingStack queue = new QueueUsingStack();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Contents of Queue: " + queue.toString());
        System.out.println("Size: " + queue.size());
        System.out.println("First element: " + queue.element());
        queue.add(40);
        System.out.println("Contents of Queue after peeking: " + queue.toString());
        System.out.println("Removing: " + queue.remove());
        queue.add(50);
        System.out.println("Contents of Queue after removing first element: " + queue.toString());
        System.out.println("Size: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }


}
