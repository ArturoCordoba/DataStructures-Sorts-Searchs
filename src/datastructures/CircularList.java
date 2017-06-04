package datastructures;

/**
 * Created by Arturo on 31/5/2017.
 * Clase que implementa el concepto de una lista circular
 * @param <T> Tipo de dato abstracto
 */
public class CircularList<T extends Comparable<T>> {
    private CircularNode last;
    private int size;

    /**
     * Constructor
     */
    public CircularList(){
        this.last = null;
        this.size = 0;
    }

    public CircularNode getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    /**
     * Metodo que verifica si la lista esta vacia
     * @return True si esta vacia, false si no esta vacia
     */
    public boolean isEmpty(){
        return this.last == null;
    }

    /**
     * Metodo para insertar un elemento en la lista
     * @param element Elemento a insertar
     */
    public void insertElement(T element){
        CircularNode newNode = new CircularNode(element);
        if(this.last != null){
            newNode.setNext(this.last.getNext());
            this.last.setNext(newNode);
        }
        this.last = newNode;
        this.size++;
    }

    /**
     * Metodo para obtener un elemento en la lista
     * @param data Dato que se esta buscando
     * @return El nodo con el si se encontraba en la lista, null si no estaba
     */
    public T getElement(T data){
        T nodeData = null;
        if(this.last != null) {
            CircularNode current = this.last.getNext();
            do {
                if(current.getData().compareTo(data) == 0){ //Se ha encontrado el elemento
                    nodeData = (T) current.getData();
                }
                current = current.getNext();
            } while (current != this.last.getNext());
        }
        return nodeData;
    }

    /**
     * Metodo para eliminar un elemento en la lista
     * @param element Elemento que se desea eliminar
     */
    public void deleteElement(T element){
        CircularNode current = this.last;
        boolean found = false;

        while (current.getNext() != this.last && !found){
            found = (current.getNext().getData().compareTo(element) == 0);
            if(!found) current = current.getNext();
        }
        found = (current.getNext().getData().compareTo(element) == 0);
        if(found){
            CircularNode aux = current.getNext();
            if(this.last == this.last.getNext()){ //Caso en el que la lista solo hay un elemento
                this.last = null;
            } else{ //Hay mas de un elemento en la lista
                if(aux == this.last) this.last = current;
                current.setNext(aux.getNext());
            }
            aux = null;
        }
    }

    /**
     * Metodo para imprimir la lista
     */
    public void printList(){
        if(this.last != null) {
            CircularNode current = this.last.getNext();
            do {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            } while (current != this.last.getNext());
            System.out.println("");
        }
    }
}
