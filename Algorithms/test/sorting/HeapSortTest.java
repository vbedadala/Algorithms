package sorting;

import org.junit.Test;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class HeapSortTest {

    @Test
    public void testSort() {
        int[] keys = {5, 7, 111, 2, 1, 200, 4, 12, 1};
        HeapSort hs = new HeapSort();
        hs.sort(keys);
    }
}
