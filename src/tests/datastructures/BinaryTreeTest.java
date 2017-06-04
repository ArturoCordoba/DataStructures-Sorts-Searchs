package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class BinaryTreeTest {
    private BinaryTree tree;

    public BinaryTreeTest(){
        this.tree = new BinaryTree();
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(15);
        tree.insert(30);
    }

    @Test
    public void getRoot() throws Exception {
        assertEquals(50, tree.getRoot().getData());
    }

    @Test
    public void contains() throws Exception {
        assertEquals(true, tree.contains(15));
        assertEquals(false, tree.contains(100));
    }

    @Test
    public void getElement() throws Exception {
        assertEquals(15, tree.getElement(15).getData());
    }

    @Test
    public void insert() throws Exception {
        tree.insert(0);
        assertEquals(true, tree.contains(0));

        tree.insert(65);
        assertEquals(true, tree.contains(65));
    }

    @Test
    public void remove() throws Exception {
        tree.remove(25);
        assertEquals(30, tree.getRoot().getLeft().getData());
    }

}