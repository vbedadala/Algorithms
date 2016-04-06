package graphs;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by vasant on 12/4/15.
 */

public class UnDirectedGraphTest {

    graphs.UndirectedGraph g = new UndirectedGraph(10);

    @Before
    public void init() {
        g.addEdge(0, 3);
        g.addEdge(0, 6);
        g.addEdge(0, 2);
        g.addEdge(4, 3);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        g.addEdge(0, 5);
        g.addEdge(6, 4);
        g.addEdge(1, 2);
        g.addEdge(5, 0);

    }

    @Test
    public void testDFS() {
        g.dfs(0);
        System.out.println("Path from 0 to 4");
        g.pathTo(4, 0);

    }

    @Test
    public void testCycle() {
        //System.out.println(g.hasCycle(0));

    }

    @Test
    public void testBFS() {
        g.bfs(0);
    }
}
