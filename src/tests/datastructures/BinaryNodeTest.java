package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class BinaryNodeTest {
    private BinaryNode node;
    private BinaryNode nodeLeft;
    private BinaryNode nodeRight;

    public BinaryNodeTest(){
        node = new BinaryNode(50);
        nodeLeft = new BinaryNode(25);
        nodeRight = new BinaryNode(75);

        node.setLeft(nodeLeft);
        node.setRight(nodeRight);
    }

    @Test
    public void getData() throws Exception {
        assertEquals(50, node.getData());
        assertEquals(25, nodeLeft.getData());
        assertEquals(75, nodeRight.getData());
    }

    @Test
    public void setData() throws Exception {
        node.setData(51);
        nodeLeft.setData(26);
        nodeRight.setData(76);

        assertEquals(51, node.getData());
        assertEquals(26, nodeLeft.getData());
        assertEquals(76, nodeRight.getData());
    }

    @Test
    public void getLeft() throws Exception {
        assertEquals(nodeLeft, node.getLeft());
    }

    @Test
    public void setLeft() throws Exception {
        BinaryNode node1 = new BinaryNode(0);
        node.setLeft(node1);

        assertEquals(node1, node.getLeft());
    }

    @Test
    public void getRight() throws Exception {
        assertEquals(nodeRight, node.getRight());
    }

    @Test
    public void setRight() throws Exception {
        BinaryNode node1 = new BinaryNode(85);
        node.setRight(node1);

        assertEquals(node1, node.getRight());
    }

}