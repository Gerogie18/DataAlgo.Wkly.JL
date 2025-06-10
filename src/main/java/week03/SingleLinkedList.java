package week03;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public SingleLinkedList (int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
    }

    public void insert(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) { //linkedlist is empty
            head = node;
            tail = node;
            size = 1;
        } else if (location == 0) { //insert at beginning
            node.next = head;
            head = node;
            size++;
        } else if (location >= size) { //insert at end
            node.next = null;
            tail.next = node;
            tail = node;
            size++;
        } else {//inset in the middle
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            size++;
        }
    }

    public void traverse() {
        if (head == null) {
            System.out.println("Linked List does not exist");
        }
        System.out.println("Linked List: ");
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            assert tempNode != null;
            System.out.print(tempNode.value);
            if (i !=size -1) {
                System.out.print("->");
            }
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void delete(int position) {
        if (head == null) { // if list is empty
            System.out.println("Empty list: nothing to delete");
            return;
        }
        if (position < 0 ||  position >= size) { // invalid position
            System.out.println("Invalid position.  Please enter a position between [0, " + (size-1) +"]");
            return;
        }
        if (position == 0) { //delete first node
            head = head.next;
            if (size == 1) { //if there is only one node
                tail = null;
            }
        } else { //delete at end or middle
            Node tempNode = head;
            int index = 0;
            while (index < position -1) {
                tempNode = tempNode.next; //tempNode is the node before the node to be deleted.
                index++;
            }
            if (position == size-1) {//delete end node
                tempNode.next = null;
                tail = tempNode;
            }else { //delete node from middle
                tempNode.next = tempNode.next.next;
            }
        }
        size--;
    }
}
