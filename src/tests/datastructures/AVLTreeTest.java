package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class AVLTreeTest {
    private AVLTree tree;

    public AVLTreeTest(){
        this.tree = new AVLTree();

        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(15);
        tree.insert(20);
    }
    @Test
    public void getRoot() throws Exception {
        assertEquals(50, tree.getRoot().getData());
    }

    @Test
    public void getElement() throws Exception {
        assertEquals(15, tree.getElement(15).getData());
    }

    @Test
    public void insert() throws Exception {
        tree.insert(85);
        assertEquals(85, tree.getElement(85).getData());
    }

    @Test
    public void remove() throws Exception {
        tree.remove(20);
        assertEquals(15, tree.getRoot().getLeft().getData());

    }
}