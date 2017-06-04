package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class GraphNodeTest {
    private GraphNode node;

    public GraphNodeTest(){
        node = new GraphNode("Cartago");
    }

    @Test
    public void getVertex() throws Exception {
        assertEquals("Cartago", node.getVertex());
    }

    @Test
    public void addEdge() throws Exception {
        assertEquals(0, node.getEdgeCount());

        GraphNode node2 = new GraphNode("San Jose");
        node.addEdge(node2, 15);

        assertEquals(1, node.getEdgeCount());
    }

    @Test
    public void removeEdge() throws Exception {
        GraphNode node2 = new GraphNode("San Jose");
        node.addEdge(node2, 15);

        node.removeEdge(node2);

        assertEquals(0, node.getEdgeCount());
    }

    @Test
    public void hasEdge() throws Exception {
        GraphNode node2 = new GraphNode("San Jose");
        assertEquals(false, node.hasEdge(node2));

        node.addEdge(node2, 15);
        assertEquals(true, node.hasEdge(node2));
    }

    @Test
    public void getEdgeCount() throws Exception {
        assertEquals(0, node.getEdgeCount());

        GraphNode node2 = new GraphNode("San Jose");
        node.addEdge(node2, 15);

        assertEquals(1, node.getEdgeCount());
    }

    @Test
    public void isVisited() throws Exception {
        assertEquals(false, node.isVisited());
    }

    @Test
    public void setVisited() throws Exception {
        assertEquals(false, node.isVisited());
        node.setVisited(true);
        assertEquals(true, node.isVisited());
    }
}