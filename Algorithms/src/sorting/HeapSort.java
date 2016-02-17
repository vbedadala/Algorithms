package sorting;

import heap.MaxHeap;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class HeapSort {

    public void sort(int [] input) {
        MaxHeap heap = new MaxHeap(input);
        int i=input.length;
        while(i>0) {
            System.out.println(heap.delMax());
            i--;
        }
    }
}
