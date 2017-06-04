package datastructures;

/**
 * Created by Arturo on 22/4/2017.
 * Clase que implementa el algoritmo de un arbol binario de busqueda
 * @param <T> Tipo de dato abstracto
 */
public class BinaryTree<T extends Comparable> {
    private BinaryNode root; //Raiz del arbol

    /**
     * Constructor
     */
    public BinaryTree(){
        this.root = null;
    }

    public BinaryNode getRoot() {
        return root;
    }

    /**
     * Metodo que verifica si un elemento se encuentra dentro del arbol
     * @param data Elemento que se desea verificar si esta dentro del arbol
     * @return True si se encuentra, false en caso contrario
     */
    public boolean contains(T data) {
        return this.contains(data, this.root);
    }


    /**
     * Metodo recursivo que verifica si un elemento se encuentra dentro del arbol
     * @param element Elemento que se desea verificar si esta dentro del arbol
     * @param node Nodo actual
     * @return True si se encuentra, false en caso contrario
     */
    private boolean contains(T element, BinaryNode node){
        if(node == null){ //Si el arbol esta vacio
            return false;
        } else if(node.getData().compareTo(element) == 0) {
            return true;
        } else if (node.getData().compareTo(element) > 0){
            return contains(element, node.getLeft());
        } else if (node.getData().compareTo(element) < 0){
            return contains(element, node.getRight());
        } else{
            return false;
        }
    }

    /**
     * Metodo que encuentra el hijo menor del arbol
     * @return El nodo menor
     */
    public BinaryNode findMin(){
        return findMin(this.root);
    }

    /**
     * Metodo que encuentra el hijo menor de un nodo ingresado
     * @param binaryNode Nodo actual
     * @return El hijo menor
     */
    private BinaryNode findMin(BinaryNode binaryNode){
        if(binaryNode == null){
            return null;
        } else if(binaryNode.getLeft() == null){
            return binaryNode;
        } else{
            return findMin(binaryNode.getLeft());
        }
    }

    /**
     * Metodo para insertar un nuevo elemento en el arbol
     * @param element Nuevo elemento
     */
    public void insert(T element){
        this.root = this.insert(element, this.root);
    }

    /**
     * Metodo recursivo para insetar un nuevo elemento en el arbol
     * @param element Elemento a insertar
     * @param current Nodo actual
     * @return Se retorna el current
     */
    private BinaryNode insert(T element, BinaryNode current){
        if(current == null){
            return new BinaryNode(element, null, null);
        } else if(current.getData().compareTo(element) > 0){
            current.setLeft(this.insert(element, current.getLeft()));
        } else if(current.getData().compareTo(element) < 0){
            current.setRight(this.insert(element, current.getRight()));
        }
        return current;
    }

    /**
     * Metodo para eliminar un elemeno del arbol
     * @param element Elemento a eliminar
     */
    public void remove(T element){
        this.root = remove(element, this.root);
    }

    /**
     * Metodo recursivo para eliminar un elemento del arbol
     * @param element Elemento a eliminar
     * @param node Nodo actual
     * @return Nodo correspondiente segun la eliminacion
     */
    private BinaryNode remove(T element, BinaryNode node){
        if(node == null){
            return node;
        }
        if(node.getData().compareTo(element) > 0){
            node.setLeft(remove(element, node.getLeft()));
        } else if(node.getData().compareTo(element) < 0){
            node.setRight(remove(element, node.getRight()));
        } else if(node.getLeft() != null && node.getRight() != null){
            node.setData(findMin(node.getRight()).getData());
            T nodeData = (T) node.getData();
            node.setRight(remove(nodeData, node.getRight()));
        } else{
            node = node.getLeft() != null ? node.getLeft(): node.getRight();
        }
        return node;
    }

    /**
     * Metodo para imprimir el arbol en pre-orden
     * @param node
     */
    public void printPreOrden(BinaryNode node){
        if(node != null){
            System.out.print(node.getData() + ", ");
            printPreOrden(node.getLeft());
            printPreOrden(node.getRight());
        }
    }

    /**
     * Metodo para imprimir el arbol en orden
     * @param node
     */
    public void printInOrden(BinaryNode node){
        if(node != null){
            printInOrden(node.getLeft());
            System.out.print(node.getData() + ", ");
            printInOrden(node.getRight());
        }
    }

    /**
     * Metodo para imprimir el arbol en postorden
     * @param node
     */
    public void printPostOrden(BinaryNode node){
        if(node != null){
            printPostOrden(node.getLeft());
            printPostOrden(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }

}