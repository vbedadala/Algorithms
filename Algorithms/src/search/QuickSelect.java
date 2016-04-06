package search;

import java.util.Random;

/**
 * Created by vasant on 2/14/16.
 */
public class QuickSelect {

    Random random = new Random();

    public int select(int[] x, int start, int end, int nth) {
        if (start < end) {
            int pivot = partition(x, start, end);
            int rank = pivot - start + 1;
            if (rank == nth) {
                return x[pivot];
            }
            if (nth < rank) {
                return select(x, start, pivot - 1, nth);
            } else
                return select(x, pivot + 1, end, nth - rank);
        }
        return -1;
    }

    private int partition(int[] x, int p, int q) {
        int pivot = random.nextInt(q - p + 1) + p;

        swap(q, pivot, x);

        int i = p - 1;
        for (int j = p; j < q; j++) {
            if (x[j] <= x[q]) {
                i++;
                swap(i, j, x);
            }
        }
        swap(q, i + 1, x);
        return i + 1;
    }

    private void swap(int i, int j, int[] x) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
}
