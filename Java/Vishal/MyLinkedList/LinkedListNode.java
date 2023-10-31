package MyLinkedList;

public class LinkedListNode {

    Node head;

    public void insert(int inputValue) {
        Node inputNode = new Node();
        inputNode.input = inputValue;

        if(head == null) {
            head = inputNode;
        } else {
            Node addNewNode;
            addNewNode = head;
            while(addNewNode.next != null) {
                addNewNode = addNewNode.next;
            }
            addNewNode.next = inputNode;
        }
    }

    public void insertAtStart(int inputvalue) {
        Node inputNode = new Node();
        inputNode.input = inputvalue;
        inputNode.next = head;
        head = inputNode;
    }

    public void insertAtIndex(int index, int inputValue) {

        Node inputNode = new Node();
        inputNode.input = inputValue;
        int curIndex = 0;
        Node addNewNodeInBetween = head;
        while (curIndex<index-1) {
            addNewNodeInBetween = addNewNodeInBetween.next;
            curIndex++;
        }
        inputNode.next = addNewNodeInBetween.next;
        addNewNodeInBetween.next = inputNode;

    }

    public void findAtIndex(LinkedListNode linkedListNode, int index) {

        int curIndex = 0;
        Node searchForValueNode = linkedListNode.head;
        while(curIndex < index) {
            searchForValueNode = searchForValueNode.next;
            curIndex++;
        }
        System.out.println("Value at Index " + linkedListNode.head.input);
    }

    public void findWithValue(LinkedListNode linkedListNode, int searchValue) {
        int foundValue = 0;
        Node searchForValueNode = linkedListNode.head;
        while(searchForValueNode.next != null) {
            if(searchForValueNode.input == searchValue) {
                foundValue = searchForValueNode.input;
                System.out.println("Searched result found in between " + searchForValueNode.input);
                return;
            }
            searchForValueNode = searchForValueNode.next;
        }
        if (searchForValueNode.input == searchValue) {
            foundValue = searchForValueNode.input;
            System.out.println("Searched result found at the end " + searchForValueNode.input);
            return;
        }
        System.out.println("No such value");
    }

    public void printValues(Node node) {

        while (node.next != null) {
            System.out.println(node.input);
            node = node.next;
        }
        System.out.println(node.input);
    }

    public int findMiddle() {
	
	    Node slow = head;
	    Node fast = head;

	    while(fast.next != null && fast.next.next != null) {
		    slow = slow.next;
		    fast = fast.next.next;
	    }
	    return slow.input;
    }

    public Boolean detectCycle(Node head) {
	
	    Node slow = head;
	    Node fast = head;
	
	    while(fast.next != null && fast.next.next !=null) {
		    slow = slow.next;
		    fast = fast.next.next;
		    if(slow == fast) {
			    return true;
		    }
	    }
	    return false;	
    }

    public int returnFirstElementInLoop(Node head) {
        Node slow = head;
	    Node fast = head;
        boolean isLoopExists = false;
	
	    while(fast.next != null && fast.next.next !=null) {
		    slow = slow.next;
		    fast = fast.next.next;
		    if(slow == fast) {
			    isLoopExists = true;
                break;
		    }
	    }
        if(isLoopExists) {
            slow = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.input;
        }
	    return 0;
    }

    public void remove(LinkedListNode linkedListNode, int index) {
        int curIndex=0;
        if(index == 0) {
            linkedListNode.head = linkedListNode.head.next;
        } else {
            Node removeNodeAtIndex = linkedListNode.head;
            Node newNode = null;
            while(curIndex<index-1) {
                removeNodeAtIndex = removeNodeAtIndex.next;
                curIndex++;
            }
            newNode = removeNodeAtIndex.next;
            removeNodeAtIndex.next = newNode.next;

        }
    }
}
