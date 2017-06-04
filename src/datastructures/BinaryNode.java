package datastructures;

/**
 * Created by Arturo on 22/4/2017.
 */
public class BinaryNode<T extends Comparable>{
    private T data;
    private BinaryNode left;
    private BinaryNode right;

    /**
     * Constructor
     * @param data Informacion que va a almacenar el nodo
     */
    public BinaryNode(T data){
        this(data, null, null);
    }

    /**
     * Constructor
     * @param data Informacion que va a almacenar el nodo
     * @param left Hijo izquierdo del nodo
     * @param right Hijo derecho del nodo
     */
    public BinaryNode(T data, BinaryNode left, BinaryNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
