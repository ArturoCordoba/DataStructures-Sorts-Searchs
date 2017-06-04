package datastructures;

import datastructures.AVLNode;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class AVLNodeTest {
    private AVLNode node;

    public AVLNodeTest(){
        this.node = new AVLNode(50);
        node.setRight(new AVLNode(75));
        node.setLeft(new AVLNode(25));
    }
    @Test
    public void getData() throws Exception {
        assertEquals(50, node.getData());
    }

    @Test
    public void setData() throws Exception {
        node.setData(65);
        assertEquals(65, node.getData());
    }

    @Test
    public void getBalanceFactor() throws Exception {
        assertEquals(0, node.getBalanceFactor());
    }

    @Test
    public void setBalanceFactor() throws Exception {
        node.setBalanceFactor(2);
        assertEquals(2, node.getBalanceFactor());
    }

    @Test
    public void getLeft() throws Exception {
        assertEquals(25, node.getLeft().getData());
    }

    @Test
    public void setLeft() throws Exception {
        AVLNode left = new AVLNode(2);
        node.setLeft(left);
        assertEquals(left, node.getLeft());
    }

    @Test
    public void getRight() throws Exception {
        assertEquals(75, node.getRight().getData());
    }

    @Test
    public void setRight() throws Exception {
        AVLNode right = new AVLNode(2);
        node.setRight(right);
        assertEquals(right, node.getRight());
    }

}