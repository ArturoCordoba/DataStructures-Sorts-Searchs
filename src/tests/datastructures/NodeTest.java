package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class NodeTest {
    private Node node1;
    private Node node2;
    private Node node3;

    public NodeTest(){
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);

        node1.setNext(node2);
        node2.setNext(node3);
    }

    @Test
    public void getDataT() throws Exception {
        assertEquals(1, node1.getDataT());
        assertEquals(2, node2.getDataT());
        assertEquals(3, node3.getDataT());
    }

    @Test
    public void setDataT() throws Exception {
        node1.setDataT(100);
        node2.setDataT(200);
        node3.setDataT(300);

        assertEquals(100, node1.getDataT());
        assertEquals(200, node2.getDataT());
        assertEquals(300, node3.getDataT());
    }

    @Test
    public void getNext() throws Exception {
        assertEquals(node2, node1.getNext());
        assertEquals(node3, node2.getNext());
    }

    @Test
    public void setNext() throws Exception {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.setNext(node4);
        node2.setNext(node5);
        node3.setNext(node6);

        assertEquals(node4, node1.getNext());
        assertEquals(node5, node2.getNext());
        assertEquals(node6, node3.getNext());
    }

}