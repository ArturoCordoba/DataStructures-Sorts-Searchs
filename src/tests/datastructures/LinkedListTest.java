package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class LinkedListTest {
    private LinkedList list;

    public LinkedListTest(){
        this.list = new LinkedList();

        list.insertAtEnd(0);
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
    }


    @Test
    public void getFirst() throws Exception {
        assertEquals(0, list.getFirst().getDataT());
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(5, list.getSize());
    }

    @Test
    public void insertAtFirst() throws Exception {
        list.insertAtFirst(10);
        assertEquals(10, list.getFirst().getDataT());

        list.insertAtFirst(20);
        assertEquals(20, list.getFirst().getDataT());

        list.insertAtFirst(30);
        assertEquals(30, list.getFirst().getDataT());
    }

    @Test
    public void insertAtEnd() throws Exception {
        list.insertAtEnd(10);

        Node current1 = list.getFirst();
        for (int i = 1; i < list.getSize(); i++) { //Se recorre la lista hasta llegar al ultimo nodo
            current1 = current1.getNext();
        }

        assertEquals(10, current1.getDataT());
        assertEquals(6, list.getSize());

        list.insertAtEnd(100);

        Node current2 = list.getFirst();
        for (int i = 1; i < list.getSize(); i++) { //Se recorre la lista hasta llegar al ultimo nodo
            current2 = current2.getNext();
        }

        assertEquals(100, current2.getDataT());
        assertEquals(7, list.getSize());
    }

    @Test
    public void getElement() throws Exception {
        //Se obtiene el primer elemento
        assertEquals(0, list.getElement(0).getDataT());

        //Se obtiene el elemento del medio
        assertEquals(2, list.getElement(2).getDataT());

        //Se obtiene el elemento del final
        assertEquals(4, list.getElement(4).getDataT());
    }

    @Test
    public void deleteFirst() throws Exception {
        list.deleteFirst();
        assertEquals(1, list.getFirst().getDataT());
        assertEquals(4, list.getSize());

        list.deleteFirst();
        assertEquals(2, list.getFirst().getDataT());
        assertEquals(3, list.getSize());
    }

    @Test
    public void insertElement() throws Exception {
        //Se inserta un elemento al inicio
        list.insertElement(100, 0);
        assertEquals(100, list.getFirst().getDataT());
        assertEquals(6, list.getSize()); //Se verifica el nuevo tamaño

        //Se inserta un elemento en medio
        list.insertElement(200, 2);
        assertEquals(200, list.getElement(2).getDataT());
        assertEquals(7, list.getSize()); //Se verifica el nuevo tamaño

        //Se inserta un elemento en la posicion del elemento al final
        list.insertElement(300, list.getSize() - 1);
        assertEquals(300, list.getElement(list.getSize() - 2).getDataT());
        assertEquals(8, list.getSize()); //Se verifica el nuevo tamaño

        //Se inserta al final de la lista
        list.insertElement(400, list.getSize());
        assertEquals(400, list.getElement(list.getSize() - 1).getDataT());
        assertEquals(9, list.getSize()); //Se verifica el nuevo tamaño
    }

    @Test
    public void setElement() throws Exception {
        //Establecemos el primer elemento en la lista
        list.setElement(100, 0);
        assertEquals(100, list.getElement(0).getDataT());
        assertEquals(5, list.getSize()); //No cambia el tamaño de la lista

        //Establecemos el elemento de la posicion del medio
        list.setElement(200, 2);
        assertEquals(200, list.getElement(2).getDataT());
        assertEquals(5, list.getSize()); //No cambia el tamaño de la lista

        //Establecemos el elemento de la ultima posicion
        list.setElement(300, list.getSize() - 1);
        assertEquals(300, list.getElement(list.getSize() - 1).getDataT());
        assertEquals(5, list.getSize()); //No cambia el tamaño de la lista
    }

    @Test
    public void deleteElement() throws Exception {
        //Se elimina el primer elemento
        list.deleteElement(0);
        assertEquals(1, list.getFirst().getDataT());
        assertEquals(4, list.getSize()); //Cambia el tamaño de la lista

        //Se elimina un elemento del medio
        list.deleteElement(2);
        assertEquals(4, list.getElement(2).getDataT());
        assertEquals(3, list.getSize()); //Cambia el tamaño de la lista

        //Se elimina el ultimo elemento de la lista
        list.deleteElement(list.getSize() - 1);
        assertEquals(2, list.getElement(list.getSize() -1).getDataT());
        assertEquals(2, list.getSize()); //Cambia el tamaño de la lista
    }

    @Test
    public void cleanList() throws Exception {
        list.cleanList();
        assertEquals(0, list.getSize());
    }

}