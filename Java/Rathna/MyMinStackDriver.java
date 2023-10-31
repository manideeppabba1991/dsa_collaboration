public class MyMinStackDriver {
    public static void main(String[] args) {
        //Sample Example 1 testing
        MinStack minStack1 = new MinStack();
        minStack1.push(9);
        minStack1.push(3);
        minStack1.push(1);
        minStack1.push(4);
        minStack1.push(3);
        minStack1.push(2);
        System.out.println(minStack1.pop());

        //Sample Example 2 testing
        MinStack minStack2 = new MinStack();
        minStack2.push(-4);
        minStack2.push(8);
        minStack2.push(-6);
        minStack2.push(4);
        minStack2.push(5);
        System.out.println(minStack2.minNumber());

        //Sample Example 3 testing
        MinStack minStack3 = new MinStack();
        minStack3.push(21);
        minStack3.push(32);
        minStack3.push(14);
        minStack3.push(11);
        minStack3.push(50);
        minStack3.push(12);
        System.out.println(minStack3.minNumber());

        //Understanding problem - Scenario 1 testing
        MinStack minStack4 = new MinStack();
        minStack4.push(3);
        minStack4.push(6);
        minStack4.push(2);
        minStack4.push(9);
        minStack4.push(0);
        minStack4.push(2);
        minStack4.push(5);
        minStack4.push(-4);
        minStack4.push(12);
        minStack4.push(-9);
        minStack4.push(6);
        System.out.println("Min Value: " + minStack4.minNumber());
        System.out.println("Size: " + minStack4.size());
        System.out.println("Main Stack pop: " + minStack4.pop());
        System.out.println("Min Value: " + minStack4.minNumber());
        System.out.println("Size: " + minStack4.size());
        System.out.println("Main Stack pop: " + minStack4.pop());
        System.out.println("Min Value: " + minStack4.minNumber());
        System.out.println("Size: " + minStack4.size());
        System.out.println("Main Stack pop: " + minStack4.pop());
        System.out.println("Min Value: " + minStack4.minNumber());
        System.out.println("Size: " + minStack4.size());
        System.out.println("Main Stack pop: " + minStack4.pop());
        System.out.println("Min Value: " + minStack4.minNumber());
        System.out.println("Size: " + minStack4.size());
        System.out.println("Main Stack pop: " + minStack4.pop());

    }
}
