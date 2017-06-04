package datastructures;

/**
 * Created by Arturo on 8/5/2017.
 * Clase que implementa el algoritmo de un arbol Splay
 * @param <T> Tipo de dato abstracto
 */
public class SplayTree<T extends Comparable> {
    private SplayNode root;

    /**
     * Constructor
     */
    public SplayTree() {
        this.root = null;
    }

    public SplayNode getRoot() {
        return this.root;
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
    private boolean contains(T element, SplayNode node){
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
     * Metodo para insertar un nuevo elemento en el arbol
     * @param data Nuevo elemento que se desea insertar en el arbol
     * @return True si se inserto, false en caso contrario
     */
    public boolean insert(T data) {
        if (this.root == null) { //Caso en el que el arbol esta vacio
            this.root = new SplayNode(data);
            return true;
        }
        else
             return this.insert(data, this.root);
    }

    /**
     * Metodo para insertar un nuevo elemento en el arbol
     * @param element Dato que se desea insertar
     * @param node Nodo actual en el recorrido
     * @return True si se pudo insertar, false en caso contrario
     */
    private boolean insert(T element, SplayNode node) {
        SplayNode newNode = new SplayNode(element); //Se crea el nuevo nodo a ser insertado
        if (node.getData().compareTo(element) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                splay(element);
                return true;
            } else { //El hijo izquierdo no esta vacio
                return insert(element, node.getLeft());
            }
        } else if (node.getData().compareTo(element) < 0) {
            if (node.getRight() == null) {
                node.setRight(newNode);
                splay(element);
                return true;
            } else // El hijo derecho no esta vacio
                return insert(element, node.getRight());
        } else if (node.getData().compareTo(element) == 0) ; //Caso en el que el elemento ya esta en el arbol
        this.root = splay(element);
        return false;
    }

    /**
     * Metodo para eliminar un elemento del arbol
     * @param element Elemento a eliminar
     * @return True si se pudo eliminar, false en caso contrario
     */
    public boolean remove(T element){
        if (root == null) { //Caso en el que el arbol esta vacio
            return false;
        }

        SplayNode newTree;
        splay(element); //Si el elemento es encontrado, se asigna como raiz
        if (root.getData().compareTo(element) == 0) {
            if (root.getLeft() == null) {
                root = root.getRight();
            }
            else {
                SplayNode aux = root.getRight();
                root = root.getLeft();
                root = splay(root, element);
                root.setRight(aux);
            }
            return true;
        } else { //El elemento no estaba en el arbol
            return false;
        }
    }

    /**
     * Metodo para obtener un nodo especifico del arbol
     * @param element Dato del nodo que se quiere obtener
     * @return El nodo si el dato estaba dentro del arbol, nulo si el dato no estaba en el arbol
     */
    public SplayNode search(T element) {
        splay(element);

        if(root.getData().compareTo(element) == 0){
            return this.root;
        } else{ //Si el elemento no estaba en el arbol se retorna nulo
            return null;
        }
    }

    /**
     * Metodo que se encarga de llevar un nodo a la raiz del arbol
     * @param element Elemento del nodo que va a ser llevado a la raiz del arbol
     * @return El nuevo nodo raiz
     */
    private SplayNode splay(T element){
        if(this.root != null) { //Caso en el que el arbol no esta vacio
            root = splay(root, element);
            return root;
        } else{ //Caso en el que el arbol esta vacio
            return null;
        }
    }

    /**
     * Metodo que se encarga de llevar un nodo a la raiz del arbol
     * @param node Nodo correspondiente al recorrido
     * @param element Elemento del nodo que va a ser llevado a la raiz del arbol
     * @return El nodo correspondiente segun las rotaciones realizadas
     */
    private SplayNode splay(SplayNode node, T element) {
        if (node == null) return null;

        int cmp1 = element.compareTo(node.getData());

        if (cmp1 < 0) {
            //El elemento no esta en el arbol, por lo tanto el proceso se finaliza
            if (node.getData() == null) {
                return node;
            }
            int cmp2 = element.compareTo(node.getLeft().getData());
            if (cmp2 < 0) {
                node.getLeft().setLeft(splay(node.getLeft().getLeft(), element));
                node = rotateRight(node);
            } else if (cmp2 > 0) {
                node.getLeft().setRight(splay(node.getLeft().getRight(), element));
                if (node.getLeft().getRight() != null)
                    node.setLeft(rotateLeft(node.getLeft()));
            }
            if (node.getLeft() == null) {
                return node;
            } else{
                return rotateRight(node);
            }
        }

        else if (cmp1 > 0) {
            //El elemento no esta en el arbol, por lo tanto el proceso se finaliza
            if (node.getRight() == null) {
                return node;
            }

            int cmp2 = element.compareTo(node.getRight().getData());
            if (cmp2 < 0) {
                node.getRight().setLeft(splay(node.getRight().getLeft(), element));
                if (node.getRight().getLeft() != null)
                    node.setRight(rotateRight(node.getRight()));
            }
            else if (cmp2 > 0) {
                node.getRight().setRight(splay(node.getRight().getRight(), element));
                node = rotateLeft(node);
            }

            if (node.getRight() == null) return node;
            else                 return rotateLeft(node);
        }

        else return node;
    }

    /**
     * Rotacion derecha
     * @param node Nodo al que se le desea aplicar la rotacion
     * @return El hijo izquierdo del nodo ingresado
     */
    private SplayNode rotateRight(SplayNode node){
        SplayNode temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        return temp;
    }

    /**
     * Rotacion izquierda
     * @param node Nodo al que se le desea aplicar la rotacion
     * @return El hijo derecho del nodo ingresado
     */
    private SplayNode rotateLeft(SplayNode node){
        SplayNode temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        return temp;
    }

    /**
     * Metodo para imprimir el arbol en pre-orden
     * @param node Nodo actual segun el recorrido
     */
    public void printPreOrden(SplayNode node){
        if(node != null){
            System.out.print(node.getData() + ", ");
            printPreOrden(node.getLeft());
            printPreOrden(node.getRight());
        }
    }

    /**
     * Metodo para imprimir el arbol en orden
     * @param node Nodo actual segun el recorrido
     */
    public void printInOrden(SplayNode node){
        if(node != null){
            printInOrden(node.getLeft());
            System.out.print(node.getData() + ", ");
            printInOrden(node.getRight());
        }
    }

    /**
     * Metodo para imprimir el arbol en postorden
     * @param node Nodo actual segun el recorrido
     */
    public void printPostOrden(SplayNode node){
        if(node != null){
            printPostOrden(node.getLeft());
            printPostOrden(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }
}