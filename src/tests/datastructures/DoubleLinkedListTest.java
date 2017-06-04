package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class DoubleLinkedListTest {
    private DoubleLinkedList list;

    public DoubleLinkedListTest(){
        list = new DoubleLinkedList();

        list.insertAtEnd(83);
        list.insertAtEnd(68);
        list.insertAtEnd(35);
        list.insertAtEnd(11);
        list.insertAtEnd(75);
    }

    @Test
    public void getFirst() throws Exception {
        assertEquals(83, list.getFirst().getData());
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(5, list.getSize());

        list.insertAtEnd(5);
        assertEquals(6, list.getSize());
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(false, list.isEmpty());

        DoubleLinkedList list1 = new DoubleLinkedList();
        assertEquals(true, list1.isEmpty());

    }

    @Test
    public void insertAtEnd() throws Exception {
        list.insertAtEnd(10);

        DoubleNode current1 = list.getFirst();
        for (int i = 1; i < list.getSize(); i++) { //Se recorre la lista hasta llegar al ultimo nodo
            current1 = current1.getNext();
        }

        assertEquals(10, current1.getData());
        assertEquals(75, current1.getPrevious().getData());
        assertEquals(6, list.getSize());

        list.insertAtEnd(100);

        DoubleNode current2 = list.getFirst();
        for (int i = 1; i < list.getSize(); i++) { //Se recorre la lista hasta llegar al ultimo nodo
            current2 = current2.getNext();
        }

        assertEquals(100, current2.getData());
        assertEquals(10, current2.getPrevious().getData());
        assertEquals(7, list.getSize());
    }

    @Test
    public void insertAtFirst() throws Exception {
        list.insertAtFirst(85);
        assertEquals(85, list.getFirst().getData());
        assertEquals(83, list.getFirst().getNext().getData());
        assertEquals(6, list.getSize());

        list.insertAtFirst(96);
        assertEquals(96, list.getFirst().getData());
        assertEquals(85, list.getFirst().getNext().getData());
        assertEquals(7, list.getSize());
    }

    @Test
    public void insertElement() throws Exception {
        //Insercion al inicio
        list.insertElement(0, 0);
        assertEquals(0, list.getFirst().getData());
        assertEquals(83, list.getFirst().getNext().getData());
        assertEquals(0, list.getFirst().getNext().getPrevious().getData());
        assertEquals(6, list.getSize());

        //Insercion en el medio
        list.insertElement(2, 2);
        DoubleNode node1 = list.getElement(2);
        assertEquals(2, node1.getData());
        assertEquals(83, node1.getPrevious().getData());
        assertEquals(2, node1.getPrevious().getNext().getData());
        assertEquals(68, node1.getNext().getData());
        assertEquals(2, node1.getPrevious().getNext().getData());
        assertEquals(7, list.getSize());

        //Insercion al final de la lista
        list.insertElement(500, 10);
        DoubleNode node2 = list.getElement(list.getSize() - 1);
        assertEquals(75, node2.getPrevious().getData());
        assertEquals(500, node2.getPrevious().getNext().getData());
        assertEquals(8, list.getSize());


    }

    @Test
    public void getElement() throws Exception {
        assertEquals(83, list.getElement(0).getData());
        assertEquals(35, list.getElement(2).getData());
        assertEquals(75, list.getElement(list.getSize() - 1).getData());
    }

    @Test
    public void deleteElement() throws Exception {
        //Eliminacion de un elemento del medio
        list.deleteElement(2);
        assertEquals(11 ,list.getElement(2).getData());
        assertEquals(4, list.getSize());

        //Eliminacion del primer elemento
        list.deleteElement(0);
        assertEquals(68, list.getFirst().getData());
        assertEquals(3, list.getSize());

        //Eliminacion del ultimo elemento
        list.deleteElement(list.getSize() - 1);
        assertEquals(11, list.getElement(list.getSize() - 1).getData());
        assertEquals(2, list.getSize());
    }

}