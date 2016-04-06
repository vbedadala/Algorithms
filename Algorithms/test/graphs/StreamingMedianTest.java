package graphs;

import median.StreamingMedian;
import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by vasantbedadala on 4/1/16.
 */
public class StreamingMedianTest {

    @Test
    public void testMedian() {
        StreamingMedian streamingMedian = new StreamingMedian();
        //streamingMedian.median(new Random().ints(50,1,100).toArray());
        streamingMedian.median(new Random().ints(50,1,100).toArray());

    }
}
