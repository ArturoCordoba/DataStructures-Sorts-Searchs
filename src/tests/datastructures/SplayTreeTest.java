package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class SplayTreeTest {
    private SplayTree tree;

    public SplayTreeTest(){
        this.tree = new SplayTree();

        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(10);
        tree.insert(30);

    }

    @Test
    public void getRoot() throws Exception {
        assertEquals(30, tree.getRoot().getData());
    }

    @Test
    public void contains() throws Exception {
        assertEquals(true, tree.contains(75));
        assertEquals(false, tree.contains(100));
    }

    @Test
    public void insert() throws Exception {
        tree.insert(60);
        assertEquals(true, tree.contains(60));
        assertEquals(60, tree.getRoot().getData());
    }

    @Test
    public void remove() throws Exception {
        tree.remove(30);
        assertEquals(false, tree.contains(30));
        assertEquals(25, tree.getRoot().getData());
    }

    @Test
    public void search() throws Exception {
        SplayNode node1 = tree.search(25);
        assertEquals(25, tree.getRoot().getData());
        assertEquals(25, node1.getData());

        SplayNode node2 = tree.search(75);
        assertEquals(75, tree.getRoot().getData());
        assertEquals(75, node2.getData());
    }

}