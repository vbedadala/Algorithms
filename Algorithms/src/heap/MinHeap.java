package heap;

import java.util.Comparator;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class MinHeap<T extends Comparable<T>> {
    Object[] heap;
    int size;
    int N;

    public MinHeap(int size) {
        heap = new Object[size + 1];
        this.size = size;
        this.N=0;
    }

    /**
     * Build heap from bottom up -- minheapify
     * Leaves are good as they are 1 element heaps, so start with N/2
     * O(n)
     */
    public MinHeap(T[] keys) {
        heap = new Object[keys.length + 1];
        //start with index 1, to avoid null links
        for (int i = 0; i < keys.length; i++) {
            heap[i + 1] = keys[i];
            this.N++;
        }
        for (int i = N / 2; i >= 1; i--) {
            sink(i);
        }
    }

    public T min() {
        if(!isEmpty()) {
            return (T) heap[1];
        }
        return null;
    }

    public T delMin() {
        if(!isEmpty()) {
            T min = (T)heap[1];
            exch(heap, 1, N--);
            sink(1);
            return min;
        }
        return null;
    }

    private boolean isMinHeap(int k) {
        int left = 2 * k;
        int right = 2 * k + 1;
        Comparable<? super T> key = (Comparable<? super T>) heap[k];
        if (key.compareTo((T)heap[left])>=0) return false;
        if (key.compareTo((T)heap[right])>=0) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    private void sink(int key) {
        while (2 * key <=N) {
            int k = 2 * key;
            if (k<N && (((T)heap[k]).compareTo((T) heap[k + 1])>=0)) {
                k = k + 1;
            }
            if (((T)heap[key]).compareTo((T) heap[k])<0)
                break;
            exch(heap, key, k);
            key = k;
        }
    }


    private void swim(int key) {
        //while not at root and less than parent
        while (key != 1 && ((T)heap[key]).compareTo((T)heap[(int) Math.floor(key / 2)]) <0) {
            exch(heap, key, (int) Math.floor(key / 2));
            key = (int) Math.floor(key / 2);
        }
    }

    private void exch(Object[] x, int i, int j) {
        T temp = (T)x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public void insert(T key) {
//        if (heap.length - 1 >= size) {
//            resize(2 * heap.length);
//        }

        this.N++;
        heap[N] = key;
        swim(N);
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public boolean isEmpty() {
        return this.N==0;
    }

    public int size() {
        return this.N;
    }
}
