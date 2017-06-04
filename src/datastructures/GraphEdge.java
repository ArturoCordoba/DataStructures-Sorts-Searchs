package datastructures;

/**
 * Created by Arturo on 1/6/2017.
 */
public class GraphEdge<T> {
    private GraphNode<T> node1;
    private GraphNode<T> node2;
    private int weight;

    public GraphEdge(GraphNode<T> node1, GraphNode<T> node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public GraphNode<T> fromNode() {
        return node1;
    }

    public GraphNode<T> toNode() {
        return node2;
    }

    /**
     *
     * @param node1 Posible nodo en el extremo del arco
     * @param node2 Posible nodo en el extremo del arco
     * @return True si el arco esta en medio de los nodos, false en caso contrario
     */
    public boolean isBetween(GraphNode<T> node1, GraphNode<T> node2) {
        return (this.node1 == node1 && this.node2 == node2);
    }
}
