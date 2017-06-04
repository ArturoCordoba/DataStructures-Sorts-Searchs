package datastructures;

/**
 * Created by Arturo on 7/5/2017.
 */
public class AVLNode<T extends Comparable> {
    private T data;
    private int balanceFactor;
    private AVLNode left;
    private AVLNode right;

    public AVLNode(T data){
        this.data = data;
        this.balanceFactor = 0;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }
}
