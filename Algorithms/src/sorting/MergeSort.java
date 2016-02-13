package sorting;

import java.util.Arrays;

public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        input = mergeSort(input, new int[input.length], 0, input.length);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + "    ");
        }
        return input;
    }

    private int[] mergeSort(int[] input, int[] aux, int start, int end) {
        if (start >= end) {
            return input;
        }
        int mid = start + (end - start) / 2;
        mergeSort(input, aux, start, mid);
        mergeSort(input, aux, mid + 1, end);
        merge(input, aux, start, mid, end);
        return input;
    }

    private void merge(int[] input, int[] aux, int start, int mid, int end) {
        //copy to aux
        for (int k = start; k < end; k++) {
            aux[k] = input[k];
        }
        int i = start;
        int j = mid + 1;
        for (int k = start; k < end; k++) {
            if (i >= mid) {
                input[k] = aux[j];
                j++;
            } else if (j >= end) {
                input[k] = aux[i];
                i++;
            } else if (aux[i] < aux[j]) {
                input[k] = aux[i];
                i++;
            } else {
                input[k] = aux[j];
                j++;
            }
        }
    }

}
