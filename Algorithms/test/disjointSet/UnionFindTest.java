package disjointSet;

import junit.framework.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * Created by vasantbedadala on 4/24/16.
 */
public class UnionFindTest {

    @Test
    public void testUnionAndFind() {
        UnionFind uf = new UnionFind(IntStream.range(0,100).mapToObj(e -> new Integer(e)).toArray());
        uf.union(1,3);
        Assert.assertEquals(true, uf.connected(1,3));
        Assert.assertEquals(false, uf.connected(1,4));
        uf.union(1,5);
        uf.union(4,6);
        uf.union(2,4);
        uf.union(3,5);
        uf.union(4,11);
        uf.union(66,1);
        uf.union(1,99);
        uf.union(1,6);
        Assert.assertEquals(true,uf.connected(5,6));
        uf.union(11,6);
        uf.union(55,77);
        uf.union(44,22);
        uf.union(44,21);
        uf.union(21,55);
        uf.union(73,21);
        uf.union(71,21);
        uf.union(44,99);
        Assert.assertEquals(true,uf.connected(1,21));
        Assert.assertEquals(true,uf.connected(11,99));





    }
}
