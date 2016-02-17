package sorting;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vasantbedadala on 2/8/16.
 */
public class QuickSortTest {

    @Test
    public void unsortedTest() {
        int[] x ={2,1,5,0,7,9,3,11,100,8,91,50,25};
        QuickSort quickSort = new QuickSort();
        quickSort.qsort(x,0,x.length-1);
        Assert.assertArrayEquals(quickSort.qsort(x,0,x.length-1),x);
    }
}
