package search;

import datastructures.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class SearchAlgorithmsTest {
    private LinkedList list;

    public SearchAlgorithmsTest(){
        list = new LinkedList();

        list.insertAtEnd(0);
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(8);
        list.insertAtEnd(9);
    }
    @Test
    public void binarySearch() throws Exception {
        SearchAlgorithms searchs = new SearchAlgorithms();
        int pos1 = searchs.binarySearch(list, 2);
        int pos2 = searchs.binarySearch(list, 4);
        int pos3 = searchs.binarySearch(list, 6);
        int pos4 = searchs.binarySearch(list, 9);

        assertEquals(2, pos1);
        assertEquals(4, pos2);
        assertEquals(6, pos3);
        assertEquals(9, pos4);
    }

    @Test
    public void interpolationSearch() throws Exception {
        SearchAlgorithms searchs = new SearchAlgorithms();
        int pos1 = searchs.interpolationSearch(list, 2);
        int pos2 = searchs.interpolationSearch(list, 4);
        int pos3 = searchs.interpolationSearch(list, 6);
        int pos4 = searchs.interpolationSearch(list, 9);

        assertEquals(2, pos1);
        assertEquals(4, pos2);
        assertEquals(6, pos3);
        assertEquals(9, pos4);
    }

}