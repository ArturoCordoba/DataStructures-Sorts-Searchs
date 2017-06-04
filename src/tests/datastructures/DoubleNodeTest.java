package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class DoubleNodeTest {
    private DoubleNode node0;
    private DoubleNode node1;
    private DoubleNode node2;
    private DoubleNode node3;

    public DoubleNodeTest(){
        node0 = new DoubleNode(0);
        node1 = new DoubleNode(1);
        node2 = new DoubleNode(2);
        node3 = new DoubleNode(3);

        node0.setNext(node1);
        node1.setPrevious(node0);
        node1.setNext(node2);
        node2.setPrevious(node1);
        node2.setNext(node3);
        node3.setPrevious(node2);

    }

    @Test
    public void getData() throws Exception {
        assertEquals(0, node0.getData());
        assertEquals(1, node1.getData());
        assertEquals(2, node2.getData());
        assertEquals(3, node3.getData());
    }

    @Test
    public void setData() throws Exception {
        node0.setData(10);
        node1.setData(20);
        node2.setData(30);
        node3.setData(40);

        assertEquals(10, node0.getData());
        assertEquals(20, node1.getData());
        assertEquals(30, node2.getData());
        assertEquals(40, node3.getData());
    }

    @Test
    public void getPrevious() throws Exception {
        assertEquals(node0, node1.getPrevious());
        assertEquals(node1, node2.getPrevious());
        assertEquals(node2, node3.getPrevious());
    }

    @Test
    public void setPrevious() throws Exception {
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);
        DoubleNode node6 = new DoubleNode(6);
        DoubleNode node7 = new DoubleNode(7);

        node0.setPrevious(node4);
        node1.setPrevious(node5);
        node2.setPrevious(node6);
        node3.setPrevious(node7);

        assertEquals(node4, node0.getPrevious());
        assertEquals(node5, node1.getPrevious());
        assertEquals(node6, node2.getPrevious());
        assertEquals(node7, node3.getPrevious());
    }

    @Test
    public void getNext() throws Exception {
        assertEquals(node1, node0.getNext());
        assertEquals(node2, node1.getNext());
        assertEquals(node3, node2.getNext());
    }

    @Test
    public void setNext() throws Exception {
        DoubleNode node4 = new DoubleNode(4);
        DoubleNode node5 = new DoubleNode(5);
        DoubleNode node6 = new DoubleNode(6);
        DoubleNode node7 = new DoubleNode(7);

        node0.setNext(node4);
        node1.setNext(node5);
        node2.setNext(node6);
        node3.setNext(node7);

        assertEquals(node4, node0.getNext());
        assertEquals(node5, node1.getNext());
        assertEquals(node6, node2.getNext());
        assertEquals(node7, node3.getNext());
    }

}