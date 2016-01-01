package strings;

import org.junit.Test;

/**
 * Created by vasant on 12/26/15.
 */
public class KMPTest {

    @Test
    public void testFailureFunction() {
        KMP kmp = new KMP();
       int x[] = kmp.failureFunction("ABABAC".toCharArray());
     kmp.match("SDGSDGSDGSDGSDGHSDHGSGHSHABABACDSGFDSGS","ABABAC");
        System.out.print(x);
    }
}
