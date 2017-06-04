package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class QueueTest {
    private Queue queue;

    public QueueTest(){
        this.queue = new Queue();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

    }

    @Test
    public void getFirst() throws Exception {
        assertEquals(0, queue.getFirst().getDataT());
    }

    @Test
    public void getLast() throws Exception {
        assertEquals(4, queue.getLast().getDataT());
    }

    @Test
    public void getSize() throws Exception {
        assertEquals(5, queue.getSize());
    }

    @Test
    public void enqueue() throws Exception {
        queue.enqueue(5);
        assertEquals(5, queue.getLast().getDataT());
        assertEquals(6, queue.getSize());

        queue.enqueue(6);
        assertEquals(6, queue.getLast().getDataT());
        assertEquals(7, queue.getSize());
    }

    @Test
    public void dequeue() throws Exception {
        Node node0 = queue.dequeue();
        assertEquals(0, node0.getDataT());

        Node node1 = queue.dequeue();
        assertEquals(1, node1.getDataT());

        Node node2 = queue.dequeue();
        assertEquals(2, node2.getDataT());
    }

}