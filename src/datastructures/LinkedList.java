package datastructures;

/**
 * Created by Arturo on 20/3/2017.
 * Clase que implementa el concepto de lista enlazada
 * @param <T> Tipo de datos abstracto
 */
public class LinkedList<T extends Comparable<T>> {

    protected Node first;
    protected int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    public Node getFirst() {
        return first;
    }

    private void setFirst(Node first) {
        this.first = first;
    }

    public int getSize(){
        return size;
    }

    /**
     * Metodo que inserta un nuevo elemento al inicio de la lista
     * @param data Dato que se quiere insertar
     */
    public void insertAtFirst(T data) {
        Node newNode = new Node(data);
        if (this.first == null) {
            setFirst(newNode);
        } else {
            newNode.setNext(first);
            setFirst(newNode);
        }
        size++;
    }

    /**
     * Metodo que inserta un nuevo elemento al final de la lista
     * @param data Dato que se quiere insentar
     */
    public void insertAtEnd(T data) {
        Node newNode = new Node(data);
        if (this.first == null) {
            setFirst(newNode);
        } else {
            Node current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }



    /**
     * Metodo para obtener el elemento de una posicion especifica
     * @param position Posicion del elemento deseado
     * @return El elemento deseado
     */
    public Node getElement(int position){ //El primer elemento de la list es el elemento número 0
        Node current = this.first;

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
     * Metodo que elimina el primer elemento de la lista
     */
    public void deleteFirst() {
        if(this.first != null) {
            this.first = first.getNext();
            size--;
        }
    }

    /**
     * Metodo que inserta un nuevo elemento en una posicion especifica
     * @param data Data del nuevo elemento
     * @param position Posicion del nuevo elemento
     */
    public void insertElement(T data, int position){
        Node newNode = new Node(data);
        Node current = this.first;

        if (this.first != null) {
            if (1 <= position && position < this.size) {
                for (int i = 0; i < (position - 1); i++) { //Se detiene en el nodo anterior al de la posición deseada
                    current = current.getNext();
                }
                newNode.setNext(current.getNext()); //Al nuevo nodo se le asigna la referencia al nodo siguiente
                current.setNext(newNode); //Al nodo anterior al nuevo nodo se le asigna la referencia al nuevo nodo
            }
            if (position == 0) { //caso en que la posicion deseada es como primer elemento
                newNode.setNext(this.first);
                this.first = newNode;
            }
            if (this.size <= position) {
                for (int i = 0; i < (this.size - 1); i++) { //Se detiene en el último nodo de la lista
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        } else{
            this.first = newNode;
        }
        this.size++;
    }

    /**
     * Metodo para establecer el data que esta guardando un nodo en una posicion especifica
     * @param element Elemento que se desea almacenar
     * @param position Posicion en la que se desea almacenar el elemento
     */
    public void setElement(T element, int position){
        Node current = this.first;

        if (this.first != null && position < this.size) {
            if (1 <= position && position < this.size) {
                for (int i = 0; i < (position - 1); i++) { //Se detiene en el nodo anterior al de la posición deseada
                    current = current.getNext();
                }
                current.getNext().setDataT(element);
            }
            if (position == 0) { //caso en que la posicion deseada es como primer elemento
                this.first.setDataT(element);
            }
            if (this.size <= position) {
                for (int i = 0; i < (this.size - 1); i++) { //Se detiene en el último nodo de la lista
                    current = current.getNext();
                }
                current.getNext().setDataT(element);
            }
        }
    }

    /**
     * Metodo que elimina un elemento en una posicion especifica
     * @param position Posicion del elemento a eliminar
     */
    public void deleteElement(int position) {
        if (position == 0) {
            this.deleteFirst();
        } else {
            if (position <= (this.size - 1)) {
                Node current = this.first;
                for (int i = 0; i < (position - 1); i++) {
                    current = current.getNext();
                }

                current.setNext(current.getNext().getNext());
                this.size--;
            }
        }
    }

    /**
     * Metodo que elimina un objeto si este esta dentro de la lista
     * @param object Objeto a eliminar
     */
    public void deleteElement(T object){
        Node<T> current = this.first;

        if(current.getDataT().compareTo(object) == 0){
            this.deleteFirst();
        } else{
            while(current != null && current.getNext() != null){
                if(current.getNext().getDataT().compareTo(object) == 0){
                    current.setNext(current.getNext().getNext());
                    this.size--;
                }
                current = current.getNext();
            }
        }
    }

    /**
     * Metodo para eliminar todos los elementos que se encuentren dentro de la lista
     */
    public void cleanList(){
        this.first = null;
        this.size = 0;
    }

    /**
     * Metodo para imprimir la lista
     */
    public void printList() {
        Node current = first;
        while (current != null) {
            System.out.print(current.getDataT() + " ");
            current = current.getNext();
        }
        System.out.println("");
    }
}

