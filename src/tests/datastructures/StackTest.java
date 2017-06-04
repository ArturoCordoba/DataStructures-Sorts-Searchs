package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class StackTest {
    private Stack stack;

    public StackTest(){
        this.stack = new Stack();

        stack.insert(0);
        stack.insert(1);
        stack.insert(2);
        stack.insert(3);
    }

    @Test
    public void getTop() throws Exception {
        assertEquals(3, stack.getTop());
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(4, stack.getSize());
    }

    @Test
    public void insert() throws Exception {
        stack.insert(4);
        assertEquals(4, stack.getTop());
        assertEquals(5, stack.getSize());

        stack.insert(5);
        assertEquals(5, stack.getTop());
        assertEquals(6, stack.getSize());
    }

    @Test
    public void extract() throws Exception {
        assertEquals(3, stack.extract());
        assertEquals(2, stack.extract());
        assertEquals(1, stack.extract());

    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(false, stack.isEmpty());

        Stack stack1 = new Stack();
        assertEquals(true, stack1.isEmpty());
    }

}