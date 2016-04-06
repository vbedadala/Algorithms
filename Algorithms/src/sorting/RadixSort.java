package sorting;

/**
 * Created by vasant on 2/14/16.
 */
public class RadixSort {

    public void sort(int[] x) {
        int maxValue = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > maxValue) {
                maxValue = x[i];
            }
        }

        int place = 0;
        while (true) {
            int c[] = new int[10];

            for (int k = 0; k < x.length; k++) {
                c[getDigit(x[k], place)]++;
            }

            for (int k = 1; k < c.length; k++) {
                c[k] = c[k] + c[k - 1];
            }

            int[] aux = new int[x.length];
            for (int i = x.length - 1; i >= 0; i--) {
                aux[c[x[i]]] = x[i];
                c[x[i]]--;
            }
            maxValue = maxValue / 10;
            if (maxValue <= 0) {
                break;
            } else {
                place++;
            }
        }
    }

    private int getDigit(int num, int place) {
        int digit = 0;
        while (num > 0) {
            digit = num % 10;
            if (place == 0) {
                return digit;
            }
            place--;
            num = num / 10;
        }
        return digit;
    }

}
