package heap;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class MaxHeapTest {

    @Test
    public void testMax() {
        int[] keys = {5,7,111,2,1,200,4,12,1};
        MaxHeap maxHeap = new MaxHeap(keys);
        Assert.assertEquals(maxHeap.max(),200);
    }

    @Test
    public void testDelMax() {
        int[] keys = {5,7,111,2,1,200,4,12,1};
        MaxHeap maxHeap = new MaxHeap(keys);
        Assert.assertEquals(maxHeap.delMax(),200);
        Assert.assertEquals(maxHeap.delMax(),111);
        Assert.assertEquals(maxHeap.delMax(),12);
    }
}
