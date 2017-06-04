package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class SplayNodeTest {
    private SplayNode node1;
    private SplayNode node2;
    private SplayNode node3;
    private SplayNode node4;
    private SplayNode node5;

    public SplayNodeTest(){
        node1 = new SplayNode(1);
        node2 = new SplayNode(2);
        node3 = new SplayNode(3);
        node4 = new SplayNode(4);
        node5 = new SplayNode(5);
    }


    @Test
    public void getData() throws Exception {
        assertEquals(1, node1.getData());
        assertEquals(2, node2.getData());
        assertEquals(3, node3.getData());
        assertEquals(4, node4.getData());
        assertEquals(5, node5.getData());
    }

    @Test
    public void setData() throws Exception {
        node1.setData(10);
        node2.setData(20);
        node3.setData(30);
        node4.setData(40);
        node5.setData(50);

        assertEquals(10, node1.getData());
        assertEquals(20, node2.getData());
        assertEquals(30, node3.getData());
        assertEquals(40, node4.getData());
        assertEquals(50, node5.getData());
    }

    @Test
    public void getLeft() throws Exception {
        SplayNode node6 = new SplayNode(-6);
        SplayNode node7 = new SplayNode(-7);
        SplayNode node8 = new SplayNode(-8);
        SplayNode node9 = new SplayNode(-9);
        SplayNode node10 = new SplayNode(-10);

        node1.setLeft(node6);
        node2.setLeft(node7);
        node3.setLeft(node8);
        node4.setLeft(node9);
        node5.setLeft(node10);

        assertEquals(node6, node1.getLeft());
        assertEquals(node7, node2.getLeft());
        assertEquals(node8, node3.getLeft());
        assertEquals(node9, node4.getLeft());
        assertEquals(node10, node5.getLeft());
    }

    @Test
    public void setLeft() throws Exception {
        SplayNode node6 = new SplayNode(0);
        SplayNode node7 = new SplayNode(0);
        SplayNode node8 = new SplayNode(0);
        SplayNode node9 = new SplayNode(0);
        SplayNode node10 = new SplayNode(0);

        node1.setLeft(node6);
        node2.setLeft(node7);
        node3.setLeft(node8);
        node4.setLeft(node9);
        node5.setLeft(node10);

        assertEquals(node6, node1.getLeft());
        assertEquals(node7, node2.getLeft());
        assertEquals(node8, node3.getLeft());
        assertEquals(node9, node4.getLeft());
        assertEquals(node10, node5.getLeft());
    }

    @Test
    public void getRight() throws Exception {
        SplayNode node6 = new SplayNode(6);
        SplayNode node7 = new SplayNode(7);
        SplayNode node8 = new SplayNode(8);
        SplayNode node9 = new SplayNode(9);
        SplayNode node10 = new SplayNode(10);

        node1.setRight(node6);
        node2.setRight(node7);
        node3.setRight(node8);
        node4.setRight(node9);
        node5.setRight(node10);

        assertEquals(node6, node1.getRight());
        assertEquals(node7, node2.getRight());
        assertEquals(node8, node3.getRight());
        assertEquals(node9, node4.getRight());
        assertEquals(node10, node5.getRight());
    }

    @Test
    public void setRight() throws Exception {
        SplayNode node6 = new SplayNode(0);
        SplayNode node7 = new SplayNode(0);
        SplayNode node8 = new SplayNode(0);
        SplayNode node9 = new SplayNode(0);
        SplayNode node10 = new SplayNode(0);

        node1.setRight(node6);
        node2.setRight(node7);
        node3.setRight(node8);
        node4.setRight(node9);
        node5.setRight(node10);

        assertEquals(node6, node1.getRight());
        assertEquals(node7, node2.getRight());
        assertEquals(node8, node3.getRight());
        assertEquals(node9, node4.getRight());
        assertEquals(node10, node5.getRight());
    }

}