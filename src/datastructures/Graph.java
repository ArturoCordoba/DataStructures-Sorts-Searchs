package datastructures;

import com.sun.istack.internal.Nullable;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Arturo on 1/6/2017.
 */
public class Graph<T> {
    private Map<T, GraphNode<T>> adjacencyList;

    public Graph(){
        this.adjacencyList = new HashMap<T, GraphNode<T>>();
    }

    /**
     * Añade un vertice al grafo
     * @param vertex Vertice a agregar
     * @return False si ya estaba, true si se agrego
     */
    public boolean addVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }
        adjacencyList.put(vertex, new GraphNode<>(vertex));
        return true;
    }

    /**
     * Añade un borde arco sin peso entre dos vertices en el grafo
     * @param vertex1 Vertice donde el arco empieza
     * @param vertex2 Vertice donde el arco termina
     * @return
     */
    public boolean addEdge(T vertex1, T vertex2) {
        return addEdge(vertex1, vertex2, 0);
    }

    /**
     * Añade un arco con peso entre dos vertices que estan en el grafo
     * @param vertex1 Vertice donde el arco empieza
     * @param vertex2 Vertice donde el arco termina
     * @param weight Peso del arco
     * @return False si los vertex no estaban en el grafo, true si se agrego correctamente
     */
    public boolean addEdge(T vertex1, T vertex2, int weight) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            throw new RuntimeException("Vertex does not exist");
        }

        //Se añade el arco
        GraphNode<T> node1 = getNode(vertex1);
        GraphNode<T> node2 = getNode(vertex2);
        return node1.addEdge(node2, weight);
    }

    /**
     * Metodo para remover un vertice del grafo
     * @param vertex Vertice a ser removido
     * @return False si el vertice no estaba en el grafo, true si fue removido
     */
    public boolean removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return false;
        }

        //Se obtiene el nodo a ser removido
        final GraphNode<T> toRemove = getNode(vertex);

        //Se remueven todos los arcos que apuntan al nodo
        adjacencyList.values().forEach(node -> node.removeEdge(toRemove));

        //Se remueve el nodo
        adjacencyList.remove(vertex);
        return true;
    }

    /**
     * Metodo para remover un arco dirigido entre dos vertices del grafo
     * @param vertex1 Vertice donde el arco empieza
     * @param vertex2 Vertice donde el arco termina
     * @return False si alguno de los vertices no estaba, true si el arco fue removido
     */
    public boolean removeEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).removeEdge(getNode(vertex2));
    }

    /**
     * Metodo para obtener el numero de vertices en el grafo
     * @return Cantidad de vertides
     */
    public int vertexCount() {
        return adjacencyList.keySet().size();
    }
    /**
     * Metodo para obtener el numero de arcos en el grafo
     * @return Cantidad de arcos
     */
    public int edgeCount() {
        return adjacencyList.values()
                .stream()
                .mapToInt(GraphNode::getEdgeCount)
                .sum();
    }

    /**
     * Meotod para verificar si existe un vertice en el grafo
     * @param vertex Vertice que se desea verificar su existencia
     * @return True si el vertice esta en el grafo, false en caso contrario
     */
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    /**
     * Metodo para verificar si existe un arco en el grafo
     * @param vertex1 Vertice donde el arco empieza
     * @param vertex2 Vertice donde el arco termina
     * @return True si el grafo contiene el arco, false en caso contrario
     */
    public boolean containsEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).hasEdge(getNode(vertex2));
    }

    /**
     * Metodo para obtener el camino mas corto desde un vertice inicial hasta un vertice final
     * @param startVertex Vertice donde el camino empieza
     * @param endVertex Vertice donde el camino termina
     * @return Lista de los vertices para recorrer el camino mas corto, null si tal camino no existe
     */
    @Nullable
    public List<T> shortestPath(T startVertex, T endVertex) {
        //Si el nodo no es encontrado, se retorna un camino vacio
        if (!containsVertex(startVertex) || !containsVertex(endVertex)) {
            return null;
        }
        runBFS(startVertex);

        List<T> path = new ArrayList<>();
        //Traza el camino de regreso desde el vertice final hasta el inicio
        GraphNode<T> end = getNode(endVertex);
        while (end != null && end != getNode(startVertex)) {
            path.add(end.getVertex());
            end = end.getParent();
        }
        // Si el camino es nulo, el nodo no fue encontrado
        if (end == null) {
            return null;
        }
        else {
            Collections.reverse(path);
        }
        return path;
    }

    private void runBFS(T startVertex) {
        if (!containsVertex(startVertex)) {
            throw new RuntimeException("Vertex does not exist.");
        }

        //Resetea el grafo
        resetGraph();

        //Inicia la cola
        Queue<GraphNode<T>> queue = new LinkedList<>();
        GraphNode<T> start = getNode(startVertex);
        queue.add(start);

        //Se explora el grafo
        while (!queue.isEmpty()) {
            GraphNode<T> first = queue.remove();
            first.setVisited(true);
            first.edges().forEach(edge -> {
                GraphNode<T> neighbour = edge.toNode();
                if (!neighbour.isVisited()) {
                    neighbour.setParent(first);
                    queue.add(neighbour);
                }
            });
        }
    }

    private GraphNode<T> getNode(T value) {
        return adjacencyList.get(value);
    }

    private void resetGraph() {
        adjacencyList.keySet().forEach(key -> {
            GraphNode<T> node = getNode(key);
            node.setParent(null);
            node.setVisited(false);
        });
    }


}
