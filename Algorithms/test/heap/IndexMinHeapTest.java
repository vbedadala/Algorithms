package heap;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class IndexMinHeapTest {

    @Test
    public void testMin() {
       IndexMinHeap iheap = new IndexMinHeap(100);
        iheap.insert(1,9);
        iheap.insert(2,11);
        iheap.insert(5,2);
        iheap.insert(3,10);
        iheap.insert(4,5);
        Assert.assertEquals(iheap.min(), 2);
        Assert.assertEquals(iheap.minIndex(),5);
        Assert.assertEquals(iheap.delMin(), 2);
        iheap.insert(5,3);
        Assert.assertEquals(iheap.min(), 3);
    }

    @Test
    public void testDecreaseKey() {
        IndexMinHeap iheap = new IndexMinHeap(100);
        iheap.insert(1,9);
        iheap.insert(2,11);
        iheap.insert(5,2);
        iheap.insert(3,10);
        iheap.insert(4,5);
        Assert.assertEquals(iheap.min(), 2);
        Assert.assertEquals(iheap.delMin(), 2);
        iheap.decreaseKey(3,1);
        Assert.assertEquals(iheap.min(), 1);
        Assert.assertEquals(iheap.delMin(),1);
        Assert.assertEquals(iheap.min(),5);


    }

    @Test
    public void testIncreaseKey() {
        IndexMinHeap iheap = new IndexMinHeap(100);
        iheap.insert(1,9);
        iheap.insert(2,11);
        iheap.insert(5,2);
        iheap.insert(3,10);
        iheap.insert(4,5);
        Assert.assertEquals(iheap.min(), 2);
        Assert.assertEquals(iheap.delMin(), 2);
        iheap.increaseKey(4,100);
        Assert.assertEquals(iheap.min(), 9);
        Assert.assertEquals(iheap.delMin(),9);
        Assert.assertEquals(iheap.min(),10);


    }


}
