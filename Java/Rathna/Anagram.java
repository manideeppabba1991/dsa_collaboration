import java.util.HashMap;
import java.util.LinkedList;

public class Anagram {
    public static void main(String[] args) {
        //Anagram check for Strings
        String str1 = "kilo";
        String str2 = "kill";
        boolean flag = checkAnagram(str1, str2);
        System.out.println("Are both Strings anagram or not: " + flag);

        //Anagram check for Integers
        int value1 = 12340;
        int value2 = 2314;
        boolean integerFlag = checkAnagramForIntegers(value1, value2);
        System.out.println("Are both Integers anagram or not: " + integerFlag);

        // Swap 2 variable values
        swap(10, 20);
        String str = "78";
        //Extract integer values from String
        extractIntegerFromString(str);
        int num = 678;
        //Return sum of squares of the given number digits
        int sumOfSq = sumOfSquares(num);
        System.out.println(sumOfSq);

        int[] arr = {1,2,3,4,5};
        //Reverse an array
        swapArr(arr);
        String newStr = "rat";
        //Reverse string without built-in functions
        myReverseString(newStr);
        //Reverse string without built-in functions, used StringBuilder
        myReverseStringUsingSBuilder(newStr);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        System.out.println("Before reversing: " + linkedList);
        //Reverse linked list when linkedList is passed
        reverseLinkedList(linkedList);

        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        System.out.println("Node list before reversing: " + head.toString());
        //Reverse linked list when head is passed
        reverseMyLinkedListUsingHead(head);

        Node newHead = new Node(100);
        Node m2 = new Node(200);
        Node m3 = new Node(300);
        Node m4 = new Node(400);

        newHead.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        System.out.println("Node list before reversing: " + newHead.toString());

        //Swap node values in linkedList when head is passed
        Node reverse = swapNodesInLinkedList(newHead, m2, m3);
        System.out.println("After reversing: " + reverse.toString());

    }

    //Swap node values in linkedList when head is passed
    private static Node swapNodesInLinkedList(Node head, Node n2, Node n3) {
        Node current = head;
        int node2Data = n2.getData();
        int node3Data = n3.getData();
        while(current != null) { // TC = O(n) and SC = O(1)
            if(current == n2) {
                current.setData(node3Data);
            } else if(current == n3) {
                current.setData(node2Data);
            }
            current = current.getNext();
        }
        return head;
    }

    //Reverse string without built-in functions, used StringBuilder
    private static void myReverseStringUsingSBuilder(String newStr) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = newStr.length() - 1; i >= 0; i--) { // TC = O(n) and SC = O(n)
            stringBuilder.append(newStr.charAt(i));
        }
        System.out.println("Reversed: " + stringBuilder);
    }


    //Reverse linked list when head is passed
    private static void reverseMyLinkedListUsingHead(Node head) {
        Node previous = null;
        Node current = head;
        while(current != null) { // TC = O(1) and SC = O(1)
            Node temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }
        System.out.println("Node linkedList after reversing: " + previous.toString());
    }

    //Reverse linked list when linkedList is passed
    private static void reverseLinkedList(LinkedList<Integer> linkedList) {
        int left = 0;
        int right = linkedList.size() - 1;

        while(left < right) { // TC = O(n) and SC = O(1)
            int tempLeft = linkedList.get(left);
            int tempRight = linkedList.get(right);
            linkedList.set(right, tempLeft);
            linkedList.set(left, tempRight);
            left++;
            right--;
        }
        System.out.println("Reversed LinkedList: " + linkedList);
    }

    //Reverse string without built-in functions
    private static void myReverseString(String newStr) {
        char[] charArr = newStr.toCharArray();
        int left = 0;
        int right = charArr.length - 1;
        while(left < right) { // TC = O(n) and SC = O(n)
            Character temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }
        String str = "";
       for(Character c: charArr) {
           str += c;
       }
        System.out.println(str);
    }

    //Reverse an array
    private static void swapArr(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) { // TC = O(n) and SC = O(1)
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for(int i: arr) {
            System.out.println(i);
        }
    }

    //Return sum of squares of the given number digits
    private static int sumOfSquares(int num) {
        int sum = 0;
        while(num > 0) {// TC = # of digits in the number and SC = O(1)
            int value = num % 10;
            int square = value  * value;
            sum += square;
            num = num/10;
        }
        return sum;
    }

    //Extract integer values from String
    private static void extractIntegerFromString(String str) {
        int value = 0;
        for(int i = 0; i < str.length(); i++) { // TC = O(n) and SC = O(1)
            value = value * 10 + Character.getNumericValue(str.charAt(i)) ;
        }
        System.out.println("Value: " + value);
    }

    // Swap 2 variable values
    private static void swap(int a, int b) {// TC = O(1) and SC = O(1)
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a value after swapping: " + a + " and b value after swapping: " + b);
    }
    //Anagram check for Integers
    private static boolean checkAnagramForIntegers(int value1, int value2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        if(value1 == value2) {
            return true;
        }

        while(value2 > 0) { // TC = # of digits in integer
            int key = value2 % 10;
            int counter = 1;
            if(hashMap.containsKey(key)) {
                counter = hashMap.get(key);
                counter++;
            }
            hashMap.put(key, counter);
            value2 = value2 / 10;
        }
        System.out.println(hashMap.toString());

        while(value1 > 0) {
            int key = value1 % 10;
            if(hashMap.containsKey(key)) {
                int counter = hashMap.get(key);
                if(counter == 1) {
                    hashMap.remove(key);
                } else{
                    counter--;
                    hashMap.replace(key, counter);
                }
            } else {
                return false;
            }
            value1 = value1 / 10;
        }
        return hashMap.isEmpty();
    }

    //Anagram check for Strings
    private static boolean checkAnagram(String str1, String str2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        if(str1.length() != str2.length()) {
            return false;
        }

        for(int i = 0; i < str2.length(); i++) { //TC = O(n) and SC = O(n)
            Character c = str2.charAt(i);
            int counter = 1;
            if(hashMap.containsKey(c)) {
                counter = hashMap.get(c);
                counter++;
            }
            hashMap.put(c,counter);
        }
        System.out.println(hashMap.toString());


        for(int i = 0; i< str1.length(); i++) {
            if(hashMap.containsKey(str1.charAt(i))) {
                int counter = hashMap.get(str1.charAt(i));
                if(counter == 1) {
                    hashMap.remove(str1.charAt(i));
                } else{
                    counter--;
                    hashMap.replace(str1.charAt(i), counter);
                }
            } else {
                return false;
            }
        }
        return hashMap.isEmpty();
    }
}
