public class DoublyLinkedList {
    // linked list node class
    private class Node {
        public Integer value;
        public Node prevNode;
        public Node nextNode;

        // node constructors
        public Node() {
            this.value = null;
            this.prevNode = null;
            this.nextNode = null;
        }

        public Node(Integer value) {
            this.value = value;
            this.prevNode = null;
            this.nextNode = null;
        }

        public Node(Integer value, Node prevNode, Node nextNode) {
            this.value = value;
            this.prevNode = prevNode;
            this.nextNode = nextNode;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    // creates list with empty header and trailer sentinel nodes
    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node(null, this.head, null);
        this.head.nextNode = this.tail;
    }

    // getter for list's size
    public int size() {
        return this.size;
    }

    // returns a boolean indicating whether the list is empty or not
    public boolean isEmpty() { return size == 0; }

    // returns the first element of the list (null if empty)
    public Integer first() {
        if(size != 0) {
            return this.head.nextNode.value;
        }
        return null;
    }

    // returns the last element of the list (null if empty)
    public Integer last() {
        if(size != 0) {
            return this.tail.prevNode.value;
        }
        return null;
    }

    // adds a new element to the front of the list
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if(this.size == 0) {
            // assign head and tail as surrounding nodes
            newNode.prevNode = this.head;
            newNode.nextNode = this.tail;

            // change head and tail pointers to the new node
            this.head.nextNode = newNode;
            this.tail.prevNode = newNode;
        } else {
            newNode.nextNode = this.head.nextNode;
            this.head.nextNode.prevNode = newNode;
            this.head.nextNode = newNode;
            newNode.prevNode = this.head;
        }
        this.size++;
    }

    // adds a new element to the end of the list
    public void addLast(int value) {
        Node newNode = new Node(value);
        if(this.size == 0) {
            // assign head and tail as surrounding nodes
            newNode.prevNode = this.head;
            newNode.nextNode = this.tail;

            // change head and tail pointers to the new node
            this.head.nextNode = newNode;
            this.tail.prevNode = newNode;
        } else {
            newNode.prevNode = this.tail.prevNode;
            this.tail.prevNode.nextNode = newNode;
            this.tail.prevNode = newNode;
            newNode.nextNode = this.tail;
        }
        this.size++;
    }

    // removes and returns the first element of the list (null if empty)
    public Integer removeFirst() {
        if(this.size != 0) {
            Node firstNode = this.head.nextNode; // get the first node

            firstNode.nextNode.prevNode = this.head;
            this.head.nextNode = firstNode.nextNode;

            firstNode.prevNode = null;
            firstNode.nextNode = null;

            this.size--;
            return firstNode.value;
        }
        return null;
    }

    // removes and returns the last element of the list (null if empty)
    public Integer removeLast() {
        if(this.size != 0) {
            Node lastNode = this.tail.prevNode; // get the last node

            lastNode.prevNode.nextNode = this.tail;
            this.tail.prevNode = lastNode.prevNode;

            lastNode.prevNode = null;
            lastNode.nextNode = null;

            this.size--;
            return lastNode.value;
        }
        return null;
    }

    // convert a node to a string
    private String nodeToString(Node currentNode) {
        if(currentNode.nextNode == this.tail) { // if the current node is the last node
            return currentNode.value + "";
        }
        else {
            return currentNode.value + ", " + nodeToString(currentNode.nextNode); // check next node
        }
    }

    // use nodeToString to convert the whole linked list to a string
    @Override
    public String toString() {
        Node currentNode = this.head.nextNode;

        if(this.size == 0) { //
            return "The list is empty.";
        }
        else {
            return nodeToString(currentNode); // convert current node to string
        }
    }
}
