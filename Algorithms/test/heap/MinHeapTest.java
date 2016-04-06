package heap;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class MinHeapTest {

    @Test
    public void testMin() {
        int[] keys = {5, 7, 111, 2, 1, 200, 4, 12, 0};
        MinHeap minHeap = new MinHeap(keys);
        Assert.assertEquals(minHeap.min(), 0);
    }

    @Test
    public void testDelMin() {
        int[] keys = {5, 7, 111, 2, 1, 200, 4, 12, 0};
        MinHeap minHeap = new MinHeap(keys);
        Assert.assertEquals(minHeap.delMin(), 0);
        Assert.assertEquals(minHeap.delMin(), 1);
        Assert.assertEquals(minHeap.delMin(), 2);
        Assert.assertEquals(minHeap.min(), 4);

    }

    @Test
    public void testInsertAndDelMin() {
        MinHeap minHeap = new MinHeap(100);
        minHeap.insert(1);
        minHeap.insert(11);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(5);
        Assert.assertEquals(minHeap.min(), 1);
        Assert.assertEquals(minHeap.delMin(), 1);
        Assert.assertEquals(minHeap.min(), 2);
        minHeap.insert(13);
        Assert.assertEquals(minHeap.min(), 2);
        Assert.assertEquals(minHeap.delMin(), 2);
        Assert.assertEquals(minHeap.delMin(), 5);
        minHeap.insert(0);
        Assert.assertEquals(minHeap.min(),0);
        Assert.assertEquals(minHeap.delMin(),0);
        Assert.assertEquals(minHeap.delMin(),10);
    }
}
