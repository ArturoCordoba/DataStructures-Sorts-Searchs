package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Arturo on 4/6/2017.
 */
public class GraphEdgeTest {
    private GraphEdge edge;
    private GraphNode node1;
    private GraphNode node2;

    public GraphEdgeTest(){
        node1 = new GraphNode("Cartago");
        node2 =  new GraphNode("San Jose");
        edge = new GraphEdge(node1, node2, 15);
    }

    @Test
    public void fromNode() throws Exception {
        GraphNode node = edge.fromNode();
        assertEquals(node1, node);
    }

    @Test
    public void toNode() throws Exception {
        GraphNode node = edge.toNode();
        assertEquals(node2, node);
    }

    @Test
    public void isBetween() throws Exception {
        GraphNode node = new GraphNode("Guanacaste");
        assertEquals(true, edge.isBetween(node1, node2));
        assertEquals(false, edge.isBetween(node1, node));
    }

}