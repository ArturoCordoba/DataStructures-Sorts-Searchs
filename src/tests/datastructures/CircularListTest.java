package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class CircularListTest {
    private CircularList list;

    public CircularListTest(){
        this.list = new CircularList();

        list.insertElement(5);
        list.insertElement(10);
        list.insertElement(15);
    }

    @Test
    public void getLast() throws Exception {
        assertEquals(15, list.getLast().getData());

        list.insertElement(20);

        assertEquals(20, list.getLast().getData());
    }

    @Test
    public void getSize() throws Exception {
        CircularList list1 = new CircularList();

        assertEquals(0, list1.getSize());

        list1.insertElement(5);
        list1.insertElement(10);
        list1.insertElement(15);

        assertEquals(3, list1.getSize());
    }

    @Test
    public void isEmpty() throws Exception {
        CircularList list1 = new CircularList();
        assertEquals(true, list1.isEmpty());

        assertEquals(false, list.isEmpty());
    }

    @Test
    public void insertElement() throws Exception {
        list.insertElement(150);
        assertEquals(150, list.getLast().getData());
        assertEquals(false, list.isEmpty());
        assertEquals(4, list.getSize());
    }

    @Test
    public void getElement() throws Exception {
        assertEquals(5, list.getElement(5));
        assertEquals(10, list.getElement(10));
        assertEquals(15, list.getElement(15));
        assertEquals(null, list.getElement(100));

    }

    @Test
    public void deleteElement() throws Exception {
        list.deleteElement(5);
        assertEquals(null, list.getElement(5));
        assertEquals(2, list.getSize());

        list.deleteElement(10);
        assertEquals(null, list.getElement(10));
        assertEquals(1, list.getSize());

        list.deleteElement(15);
        assertEquals(null, list.getElement(15));
        assertEquals(0, list.getSize());
        assertEquals(true, list.isEmpty());

    }
}