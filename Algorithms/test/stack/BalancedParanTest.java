package stack;

import org.junit.Test;

/**
 * Created by vasant on 6/3/16.
 */
public class BalancedParanTest {

    @Test
    public void isbalanced() {
    Balanced b = new Balanced();
        b.check("()]{}{[()()]()}");
    }
}
