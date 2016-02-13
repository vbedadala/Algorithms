package sorting;

import java.util.Random;

public class QuickSort{

  private Random random = new Random();

    public int[] qsort(int[] input, int p, int q) {

        if(p<q) {
            int pivot = partition(input, p, q);
            qsort(input, p, pivot-1);
            qsort(input, pivot + 1, q);
        }
        return input;
    }

    private int partition(int [] x, int p, int q) {
        int pivot = random.nextInt(q-p + 1) + p;

        swap(q,pivot,x);

        int i=p-1;
       for(int j=p; j<q; j++) {
           if(x[j]<=x[q]) {
             i++;
             swap(i,j,x);
           }
       }
        swap(q,i+1,x);
        return i+1;
    }

    private void swap(int i, int j, int[] x) {
        int temp=x[i];
        x[i]=x[j];
        x[j]=temp;
    }
}
