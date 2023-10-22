public class MyOwnStackUsingArrayList {
    public static void main(String[] args) {
        MyIntegerStackArrayList myStackArrayList = new MyIntegerStackArrayList();
        myStackArrayList.push(10);
        myStackArrayList.push(20);
        myStackArrayList.push(30);
        System.out.println("Viewing top element: " + myStackArrayList.peek());
        System.out.println("Size of myStack before removing top element: " + myStackArrayList.size());
        System.out.println("Removing top element: " + myStackArrayList.pop());
        System.out.println("Size of myStack after removing top element: " + myStackArrayList.size());
        System.out.println("Viewing latest top element after pop: " + myStackArrayList.peek());
        System.out.println("Is the stack empty: " + myStackArrayList.empty());
        System.out.println("Size of myStack: " + myStackArrayList.size());
    }
}
