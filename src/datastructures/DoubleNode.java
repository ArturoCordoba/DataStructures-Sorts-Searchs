package datastructures;

/**
 * Created by Arturo on 31/5/2017.
 */
public class DoubleNode<T extends Comparable<T>> {
    private T data;
    private DoubleNode next;
    private DoubleNode previous;

    public DoubleNode(T data){
        this(data, null, null);
    }

    public DoubleNode(T data, DoubleNode next, DoubleNode previous){
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}
