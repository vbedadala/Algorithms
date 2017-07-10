package ctci.arraysAndStrings;

/**
 * Created by vasant on 7/9/17.
 */
public class isUniqueChar {

    public  boolean isAllCharUniqueUsingBitVector(String s) {

        int x = 128;
        //lower case characters and ascii
        for (char c : s.toCharArray()) {
            if ((x & (1 << (c - 'a'))) > 0) {
                return false;
            }

            x |= 1 << c - 'a';
        }

        return true;
    }

    public  boolean isAllCharUniqueUsingArray(String s) {

        boolean[] x = new boolean[128];
        //lower case characters and ascii
        for (char c : s.toCharArray()) {
           if(x[c]) {
               return false;
           }
           x[c]=true;
        }

        return true;
    }



}
