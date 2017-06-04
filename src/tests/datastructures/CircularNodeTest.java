package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class CircularNodeTest {
    private CircularNode node1;
    private CircularNode node2;
    private CircularNode node3;
    private CircularNode node4;

    public CircularNodeTest(){
        node1 = new CircularNode(52);
        node2 = new CircularNode(15);
        node3 = new CircularNode(96);
        node4 = new CircularNode(85);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node1);
    }

    @Test
    public void getData() throws Exception {
        assertEquals(52, node1.getData());
        assertEquals(15, node2.getData());
        assertEquals(96, node3.getData());
        assertEquals(85, node4.getData());
    }

    @Test
    public void setData() throws Exception {
        node1.setData(74);
        node2.setData(64);
        node3.setData(45);
        node4.setData(35);

        assertEquals(74, node1.getData());
        assertEquals(64, node2.getData());
        assertEquals(45, node3.getData());
        assertEquals(35, node4.getData());
    }

    @Test
    public void getNext() throws Exception {
        assertEquals(node2, node1.getNext());
        assertEquals(node3, node2.getNext());
        assertEquals(node4, node3.getNext());
        assertEquals(node1, node4.getNext());
    }

    @Test
    public void setNext() throws Exception {
        node4.setNext(node3);
        node3.setNext(node2);
        node2.setNext(node1);
        node1.setNext(node4);

        assertEquals(node3, node4.getNext());
        assertEquals(node2, node3.getNext());
        assertEquals(node1, node2.getNext());
        assertEquals(node4, node1.getNext());
    }

}