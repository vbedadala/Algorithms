package graphs;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vasant on 12/4/15.
 */

public class UnDirectedGraphTest {

    graphs.UndirectedGraph g = new UndirectedGraph(13);

    @Before
    public void init() {
        g.addEdge(0, 5);
        g.addEdge( 4 ,3);
        g.addEdge( 0 ,1);
        g.addEdge( 9 ,12);
        g.addEdge(5 ,4);
        g.addEdge(0 ,2);
        g.addEdge(9 ,10);
        g.addEdge(11 ,1);
        //g.addEdge(1 ,0);


        g.addEdge(0 ,6);
        g.addEdge(7 ,8);
        g.addEdge(9 ,11);
        g.addEdge(5 ,9);

    }

    @After
    public void reset()
    {
        g.reset();
    }


    @Test
    public void testDFS() {
        g.dfs(0);
        System.out.println("Path from 0 to 6");
        g.pathTo(6, 0);
    }

    @Test
    public void testCycle() {
        g.hasCycle();

    }

    @Test
    public void testBiParttite() {
        g.isBiPartite();

    }

    @Test
    public void testBFS() {
        g.bfs(0);
        g.pathTo(6, 0);
    }

    @Test
    public void testCC() {
        g.cc();
        Assert.assertEquals(true,g.connected(0, 12));
    }
}
