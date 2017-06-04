package datastructures;

/**
 * Created by Arturo on 20/3/2017.
 */
public class Stack<T extends Comparable<T>> {
    private Node top;
    private int size;

    /**
     * Constructor
     */
    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public T getTop() {
        return (T)top.getDataT();
    }

    public int getSize() {
        return size;
    }

    /**
     * Metodo para insertar un nuevo elemento a la pila
     * @param data Elemento que se desea insertar
     */
    public void insert(T data){
        Node newNode = new Node(data);
        newNode.setNext(this.top);
        this.top = newNode;
        this.size++;
    }

    /**
     * Metodo que extrae un elemento de la pila
     * @return El primer nodo de la pila
     */
    public T extract(){
        Node nodeTop = this.top;
        if(this.top != null){
            this.top = this.top.getNext();
        }
        if(0 < this.size){
            this.size--;
        }
        return (T)nodeTop.getDataT();
    }

    /**
     * Metodo que determina si la pila esta vacia
     * @return True si la lista esta vacia, false si tiene algun elemento
     */
    public boolean isEmpty(){
        if(0 == this.size) {
            return true;
        } else{
            return false;
        }
    }

    public void printStack(){
        Node current = this.top;
        while(current != null){
            System.out.print(current.getDataT() + " ");
            current = current.getNext();
        }
        System.out.println("");
    }
}
