package disjointSet;

import junit.framework.Assert;
import org.junit.Test;
import stack.MinStack;

/**
 * Created by vasant on 6/3/16.
 */
public class MinStackTest {


    @Test
    public void testMin(){

        MinStack<Integer> minStack = new MinStack(10);
        minStack.push(1);
        Assert.assertEquals(new Integer(1), minStack.min());
        minStack.push(2);
        minStack.push(3);
        Assert.assertEquals(new Integer(1), minStack.min());
        Assert.assertEquals(new Integer(3), minStack.pop());
        Assert.assertEquals(new Integer(1), minStack.min());
        minStack.push(0);
        Assert.assertEquals(new Integer(0), minStack.min());







    }
}
