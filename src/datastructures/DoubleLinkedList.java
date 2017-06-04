package datastructures;

/**
 * Created by Arturo on 31/5/2017.
 * Clase que implementa el concepto de una lista doblemente enlazada
 * @param <T> Tipo de dato abstracto
 */
public class DoubleLinkedList<T extends Comparable<T>> {
    private DoubleNode first;
    private int size;

    /**
     * Constructor
     */
    public DoubleLinkedList(){
        this.first = null;
        this.size = 0;
    }

    public DoubleNode getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

    /**
     * Metodo para saber si la lista esta vacia
     * @return True si la lista esta vacia, false si tiene elementos
     */
    public boolean isEmpty(){
        return this.first == null;
    }

    /**
     * Metodo que inserta un nuevo elemento al final de la lista
     * @param data Dato que se quiere insentar
     */
    public void insertAtEnd(T data) {
        DoubleNode newNode = new DoubleNode(data);
        if (this.first == null) {
            this.first = newNode;
        } else {
            DoubleNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrevious(current);
        }
        this.size++;
    }

    /**
     * Metodo que inserta un nuevo elemento al inicio de la lista
     * @param data Dato que se quiere insertar
     */
    public void insertAtFirst(T data) {
        DoubleNode newNode = new DoubleNode(data, this.first, null);
        this.first.setPrevious(newNode);
        this.first = newNode;
        size++;
    }

    /**
     * Método que inserta un nuevo elemento en una posición específica
     * @param data Data del nuevo elemento
     * @param position Posicion deseada del nuevo elemento
     */
    public void insertElement(T data, int position){
        DoubleNode newNode = new DoubleNode(data);
        DoubleNode current = this.first;

        if (this.first != null) {
            if (1 <= position && position < this.size) {
                for (int i = 0; i < (position - 1); i++) { //Se detiene en el nodo anterior al de la posición deseada
                    current = current.getNext();
                }
                newNode.setNext(current.getNext()); //Al nuevo nodo se le asigna la referencia al nodo siguiente
                newNode.getNext().setPrevious(newNode);
                current.setNext(newNode); //Al nodo anterior al nuevo nodo se le asigna la referencia al nuevo nodo
                newNode.setPrevious(current);
            }
            if (position == 0) { //caso en que la posicion deseada es como primer elemento
                newNode.setNext(this.first);
                this.first.setPrevious(newNode);
                this.first = newNode;
            }
            if (this.size <= position) {
                for (int i = 0; i < (this.size - 1); i++) { //Se detiene en el último nodo de la lista
                    current = current.getNext();
                }
                current.setNext(newNode);
                newNode.setPrevious(current);
            }
        } else{
            this.first = newNode;
        }
        this.size++;
    }

    /**
     * Metodo para obtener el elemento de una posicion especifica
     * @param position Posicion del elemento deseado
     * @return El elemento deseado
     */
    public DoubleNode getElement(int position){ //El primer elemento de la lista es el elemento número 0
        DoubleNode current = this.first;

        if(position < this.size && position >= 0) {
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
        } else{
            return null;
        }
        return current;
    }

    /**
     * Metodo que elimina un elemento en una posicion especifica
     * @param position Posicion del elemento a eliminar
     */
    public void deleteElement(int position) {
        if(this.first != null) {
            if (position == 0) {
                this.first.getNext().setPrevious(null);
                this.first = this.first.getNext();
            } else {
                if (position <= (this.size - 1)) {
                    DoubleNode current = this.first;
                    for (int i = 0; i < (position - 1); i++) {
                        current = current.getNext();
                    }

                    current.setNext(current.getNext().getNext());
                    if(current.getNext() != null) current.getNext().setPrevious(current);
                    this.size--;
                }
            }
        }
    }

    /**
     * Metodo para imprimir la lista
     */
    public void printList() {
        DoubleNode current = first;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println("");
    }

}
