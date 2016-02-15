package sorting;

/**
 * Created by vasant on 2/14/16.
 */
public class CountingSort {

    public int[] sort(int[] a, int radix) {
        int[] c = new int[radix];

        for (int k = 0; k < c.length; k++) {
            c[k] = 0;
        }
        //counter
        for (int j = 0; j < a.length; j++) {
            c[a[j]]++;
        }
        //prefix sums or rank
        for (int k = 1; k < c.length; k++) {
            c[k] = c[k] + c[k - 1];
        }
        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[c[a[i]]] = a[i];
            c[a[i]] -= 1;
        }
        return b;
    }
}
