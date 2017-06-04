import datastructures.CircularList;
import datastructures.DoubleLinkedList;
import datastructures.DoubleNode;

/**
 * Created by Arturo on 4/6/2017.
 */
public class main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.insertAtEnd(83);
        list.insertAtEnd(68);
        list.insertAtEnd(35);
        list.insertAtEnd(11);
        list.insertAtEnd(75);

        list.deleteElement(2);
        list.printList();
        System.out.println(list.getElement(2).getData());

    }
}
