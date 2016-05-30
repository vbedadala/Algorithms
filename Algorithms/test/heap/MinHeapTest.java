package heap;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class MinHeapTest {

    @Test
    public void testMin() {
        Integer[] keys = {5, 7, 111, 2, 1, 200, 4, 12, 0};
        MinHeap<Integer> minHeap = new MinHeap<>(keys);
        Assert.assertEquals(minHeap.min(), new Integer(0));
    }

    @Test
    public void testDelMin() {
        Integer[] keys = {5, 7, 111, 2, 1, 200, 4, 12, 0};
        MinHeap<Integer> minHeap = new MinHeap<>(keys);
        Assert.assertEquals(minHeap.delMin(), new Integer(0));
        Assert.assertEquals(minHeap.delMin(), new Integer(1));
        Assert.assertEquals(minHeap.delMin(), new Integer(2));
        Assert.assertEquals(minHeap.min(), new Integer(4));

    }

    @Test
    public void testInsertAndDelMin() {
        MinHeap<Integer> minHeap = new MinHeap(100);
        minHeap.insert(1);
        minHeap.insert(11);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(5);
        Assert.assertEquals(minHeap.min(), new Integer(1));
        Assert.assertEquals(minHeap.delMin(), new Integer(1));
        Assert.assertEquals(minHeap.min(), new Integer(2));
        minHeap.insert(13);
        Assert.assertEquals(minHeap.min(), new Integer(2));
        Assert.assertEquals(minHeap.delMin(), new Integer(2));
        Assert.assertEquals(minHeap.delMin(), new Integer(5));
        minHeap.insert(0);
        Assert.assertEquals(minHeap.min(),new Integer(0));
        Assert.assertEquals(minHeap.delMin(),new Integer(0));
        Assert.assertEquals(minHeap.delMin(),new Integer(10));
    }

    @Test
    public void testMinHeapWithStrings(){
        MinHeap<String> minHeap= new MinHeap<String>(10);
        minHeap.insert("Harika");
        minHeap.insert("Varnika");
        minHeap.insert("Vasant");
        minHeap.insert("Gautam");
        Assert.assertEquals(minHeap.min(), "Gautam");
        Assert.assertEquals(minHeap.delMin(),"Gautam");
        Assert.assertEquals(minHeap.delMin(),"Harika");
        Assert.assertEquals(minHeap.min(),"Varnika");

    }
}
