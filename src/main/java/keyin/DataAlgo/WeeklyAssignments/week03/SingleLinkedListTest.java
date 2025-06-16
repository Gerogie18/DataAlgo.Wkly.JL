package week03;

public class SingleLinkedListTest {

    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList(30);
        singleLinkedList.traverse();
        singleLinkedList.insert(1, 1);
        singleLinkedList.insert(3, 2);
        singleLinkedList.insert(20, 3);
        singleLinkedList.insert(50, 4);
        singleLinkedList.traverse();
        singleLinkedList.delete(0);
        singleLinkedList.traverse();
        singleLinkedList.delete(3);
        singleLinkedList.traverse();
        singleLinkedList.delete(2);
        singleLinkedList.traverse();

    }
}
