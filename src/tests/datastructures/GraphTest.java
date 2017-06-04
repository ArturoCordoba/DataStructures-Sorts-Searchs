package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class GraphTest {
    private Graph graph;

    public GraphTest(){
        graph = new Graph();

        graph.addVertex("Limon");
        graph.addVertex("Cartago");
        graph.addVertex("San Jose");
        graph.addVertex("Alajuela");
        graph.addVertex("Heredia");
    }

    @Test
    public void addVertex() throws Exception {
        assertEquals(false, graph.containsVertex("Prueba"));
        graph.addVertex("Prueba");
        assertEquals(true, graph.containsVertex("Prueba"));
    }

    @Test
    public void addEdge() throws Exception {
        assertEquals(false, graph.containsEdge("Limon", "Cartago"));

        graph.addEdge("Limon", "Cartago");

        assertEquals(true, graph.containsEdge("Limon", "Cartago"));
    }

    @Test
    public void addEdge1() throws Exception {
        assertEquals(false, graph.containsEdge("Limon", "Cartago"));

        graph.addEdge("Limon", "Cartago", 90);

        assertEquals(true, graph.containsEdge("Limon", "Cartago"));
    }

    @Test
    public void removeVertex() throws Exception {
        assertEquals(true, graph.containsVertex("Heredia"));

        graph.removeVertex("Heredia");

        assertEquals(false, graph.containsVertex("Heredia"));
    }

    @Test
    public void removeEdge() throws Exception {
        //Se añade el arco
        graph.addEdge("Limon", "Cartago", 90);
        assertEquals(true, graph.containsEdge("Limon", "Cartago"));

        //Se elimina el arco
        graph.removeEdge("Limon", "Cartago");
        assertEquals(false, graph.containsEdge("Limon", "Cartago"));
    }

    @Test
    public void vertexCount() throws Exception {
        assertEquals(5, graph.vertexCount());
        graph.addVertex("Prueba");
        assertEquals(6, graph.vertexCount());

        graph.removeVertex("Cartago");
        graph.removeVertex("Heredia");
        assertEquals(4, graph.vertexCount());
    }

    @Test
    public void edgeCount() throws Exception {
        assertEquals(0, graph.edgeCount());
        //Se añaden dos arcos
        graph.addEdge("Limon", "Cartago");
        graph.addEdge("San Jose", "Cartago");
        assertEquals(2, graph.edgeCount());
        //Se elimina un arco
        graph.removeEdge("Limon", "Cartago");
        assertEquals(1, graph.edgeCount());

    }

    @Test
    public void containsVertex() throws Exception {
        assertEquals(false, graph.containsVertex("Prueba"));
        graph.addVertex("Prueba");

        assertEquals(true, graph.containsVertex("Prueba"));
    }

    @Test
    public void containsEdge() throws Exception {
        assertEquals(false, graph.containsEdge("Limon", "Cartago"));

        graph.addEdge("Limon", "Cartago", 90);

        assertEquals(true, graph.containsEdge("Limon", "Cartago"));
    }
}