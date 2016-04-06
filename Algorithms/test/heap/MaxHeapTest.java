package heap;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class MaxHeapTest {

    @Test
    public void testMax() {
        int[] keys = {5, 7, 111, 2, 1, 200, 4, 12, 1};
        MaxHeap maxHeap = new MaxHeap(keys);
        Assert.assertEquals(maxHeap.max(), 200);
    }

    @Test
    public void testDelMax() {
        int[] keys = {5, 7, 111, 2, 1, 200, 4, 12, 1};
        MaxHeap maxHeap = new MaxHeap(keys);
        Assert.assertEquals(maxHeap.delMax(), 200);
        Assert.assertEquals(maxHeap.delMax(), 111);
        Assert.assertEquals(maxHeap.delMax(), 12);
    }

    @Test
    public void testInsertAndDelMax() {
        MaxHeap maxHeap = new MaxHeap(100);
        maxHeap.insert(1);
        maxHeap.insert(11);
        maxHeap.insert(2);
        maxHeap.insert(10);
        maxHeap.insert(5);
        Assert.assertEquals(maxHeap.max(),11);
        Assert.assertEquals(maxHeap.delMax(),11);
        Assert.assertEquals(maxHeap.max(),10);
        maxHeap.insert(13);
        Assert.assertEquals(maxHeap.max(),13);
        Assert.assertEquals(maxHeap.delMax(),13);
        Assert.assertEquals(maxHeap.delMax(),10);










    }
}
