// --== CS400 File Header Information ==--
// Name: Sarah Brown
// Email: snbrown@wisc.edu
// Team: gf
// TA: Dan Kiel
// Lecturer: Florian Heimerl
// Notes to Grader:

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private Graph<Integer> graph;
    @BeforeEach
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    public void createGraph() {
        graph = new Graph<>();
        // insert vertices 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        // insert edges from Week 08. Dijkstra's Activity
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,7,2);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(3,7,2);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,0,2);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1);
        graph.insertEdge(7,0,3);
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
    }

    /**
     * Checks the distance/total weight cost from the vertex labeled 0 to 8
     * (should be 15), and from the vertex labeled 9 to 8 (should be 17).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost(0,8) == 15);    
        assertTrue(graph.getPathCost(9,8) == 17);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labeled 0 to 8, and from the vertex labeled 9 to 8.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath(0, 8).toString().equals(
            "[0, 2, 6, 3, 1, 8]"
        ));
        assertTrue(graph.shortestPath(9, 8).toString().equals(
            "[9, 4, 5, 1, 8]"
        ));
    }
    
    /**
     * Checks the distance from the vertex labeled 6 to 5
     * (should be 15), the shortest path with the longest
     * cost from my assigned start node. I misunderstood 
     * the question when I originally did the activity so 
     * I hope that I understood it right this time.
     */
    @Test
    public void testLongestPathCost() {
        assertTrue(graph.getPathCost(6, 5) == 15);
    }
    
    /**
     * Checks the ordered sequence of data within vertices from
     * vertex 6 to vertex 5. 
     */
    @Test
    public void testLongestPathContents() {
        assertTrue(graph.shortestPath(6, 5).toString().equals(
            "[6, 3, 7, 0, 2, 4, 5]"
        ));
    }
    
    /**
     * Checks the distance from the vertices labeled 7 to 9
     * (should be 8),
     * 4 to 6 (should be 10), and 6 to 9 (should be 14).
     */
    @Test
    public void testMorePathCosts() {      
        assertTrue(graph.getPathCost(7, 1) == 8);
        assertTrue(graph.getPathCost(4, 6) == 10);
        assertTrue(graph.getPathCost(6, 9) == 14);;
    }
    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labeled 7 to 1, from the vertex labeled 4 to 6, and from the vertex 
     * labeled 6 to 9.
     */
    @Test
    public void testMorePathContents() {
        assertTrue(graph.shortestPath(7, 1).toString().equals(
            "[7, 6, 3, 1]"
        ));
        assertTrue(graph.shortestPath(4, 6).toString().equals(
            "[4, 5, 0, 2, 6]"
        ));
        assertTrue(graph.shortestPath(6, 9).toString().equals(
            "[6, 3, 1, 8, 9]"
        ));
    }
}