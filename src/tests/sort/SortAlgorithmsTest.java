package sort;

import datastructures.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class SortAlgorithmsTest {
    private LinkedList list;

    public SortAlgorithmsTest(){
        list = new LinkedList();

        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(0);
        list.insertAtEnd(2);
        list.insertAtEnd(5);
        list.insertAtEnd(3);
        list.insertAtEnd(9);
        list.insertAtEnd(1);
        list.insertAtEnd(4);
        list.insertAtEnd(8);
    }

    @Test
    public void bubbleSort() throws Exception {
        SortAlgorithms.bubbleSort(list);
        boolean isOrganized = true;

        for (int i = 0; i < list.getSize(); i++) {
            if(list.getElement(i).getDataT().compareTo(i) != 0){
                isOrganized = false;
            }
        }

        assertEquals(true, isOrganized);
    }

    @Test
    public void selectionSort() throws Exception {
        SortAlgorithms.selectionSort(list);
        boolean isOrganized = true;

        for (int i = 0; i < list.getSize(); i++) {
            if(list.getElement(i).getDataT().compareTo(i) != 0){
                isOrganized = false;
            }
        }

        assertEquals(true, isOrganized);
    }

    @Test
    public void insertionSort() throws Exception {
        SortAlgorithms.insertionSort(list);
        boolean isOrganized = true;

        for (int i = 0; i < list.getSize(); i++) {
            if(list.getElement(i).getDataT().compareTo(i) != 0){
                isOrganized = false;
            }
        }

        assertEquals(true, isOrganized);
    }

    @Test
    public void shellSort() throws Exception {
        SortAlgorithms.shellSort(list);
        boolean isOrganized = true;

        for (int i = 0; i < list.getSize(); i++) {
            if(list.getElement(i).getDataT().compareTo(i) != 0){
                isOrganized = false;
            }
        }

        assertEquals(true, isOrganized);
    }

    @Test
    public void mergeSort() throws Exception {
        LinkedList list1 = SortAlgorithms.mergeSort(list);
        boolean isOrganized = true;

        for (int i = 0; i < list1.getSize(); i++) {
            if(list1.getElement(i).getDataT().compareTo(i) != 0){
                isOrganized = false;
            }
        }

        assertEquals(true, isOrganized);
    }

    @Test
    public void quickSort() throws Exception {
        SortAlgorithms.quickSort(list);
        boolean isOrganized = true;

        for (int i = 0; i < list.getSize(); i++) {
            if(list.getElement(i).getDataT().compareTo(i) != 0){
                isOrganized = false;
            }
        }

        assertEquals(true, isOrganized);
    }

    @Test
    public void radixSort() throws Exception {
        SortAlgorithms.radixSort(list);
        boolean isOrganized = true;

        for (int i = 0; i < list.getSize(); i++) {
            if(list.getElement(i).getDataT().compareTo(i) != 0){
                isOrganized = false;
            }
        }

        assertEquals(true, isOrganized);
    }

}