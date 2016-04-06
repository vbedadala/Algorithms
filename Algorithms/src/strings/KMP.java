package strings;

/**
 * Created by vasant on 12/26/15.
 */
public class KMP {

    //ABABAACBCA
    public int[] failureFunction(char[] pattern) {

        int f[] = new int[pattern.length];

        int j = 0, x = 0;
        f[0] = 0;

        for (int k = 1; k < pattern.length; k++) {
            //first use f[k-1] to compute f[k]
            j = f[k - 1];

            for (; ; ) {
                if (pattern[k] == pattern[j]) {

                    f[k] = j + 1;
                    break;

                }
                if (j <= 0) {
                    break;
                }

                j = f[j];


            }
        }

        return f;
    }


    public void match(String haystack, String needle) {

        int j = 0;
        int f[] = failureFunction(needle.toCharArray());
        for (int i = 0; i < haystack.length(); ) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i += 1;
                j += 1;
                if (j == needle.length() - 1) {
                    System.out.println("match found!");
                    break;
                }
            } else if (j > 0) {
                j = f[j];
            } else {
                i++;
            }

        }
        System.out.println("Match not found");
    }


}
