package datastructures;

/**
 * Created by Arturo on 31/5/2017.
 */
public class CircularNode<T extends Comparable<T>> {
    private T data;
    private CircularNode<T> next;

    public CircularNode(T data){
        this.data = data;
        this.next = this;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CircularNode<T> getNext() {
        return this.next;
    }

    public void setNext(CircularNode<T> next) {
        this.next = next;
    }
}