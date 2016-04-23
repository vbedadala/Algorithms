package sorting;

import org.junit.Test;

/**
 * Created by vasantbedadala on 4/7/16.
 */
public class KWayMergeTest {

    @Test
    public void testkmerge() {
        KWayMerge kWayMerge = new KWayMerge();
        kWayMerge.kmerge(new int[]{4,6,9}, new int[]{1,3,7},new int[] {2,11,13} ,new int[] {5,55,111});
    }
}
