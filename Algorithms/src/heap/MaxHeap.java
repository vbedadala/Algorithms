package heap;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class MaxHeap {
    int[] heap;
    int N;
    int size;
    public MaxHeap(int size) {
        heap = new int[size + 1];
        this.N=0;
        this.size=size;
    }

    /**
     * Build heap from bottom up -- maxheapify
     * Leaves are good as they are 1 element heaps, so start with N/2
     * O(n)
     */
    public MaxHeap(int[] keys) {
        heap = new int[keys.length + 1];
        //start with index 1, to avoid null links
        for (int i = 0; i < keys.length; i++) {
            heap[i + 1] = keys[i];
            this.N++;
        }
        for (int i = N / 2; i >= 1; i--) {
            sink(i);
        }
    }

    public int max() {
       if(!isEmpty()) {
           return heap[1];
       }
        return -1;
    }

    public int delMax() {
        if(!isEmpty()) {
            int max = heap[1];
            exch(heap, 1, N--);
            sink(1);
            return max;
        }
        return -1;
    }

    private boolean isMaxHeap(int k) {
        int left = 2 * k;
        int right = 2 * k + 1;
        if (heap[k] <= left) return false;
        if (heap[k] <= right) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }

    private void sink(int key) {
        while (2 * key <=N) {
            int k = 2 * key;
            if (k<N && heap[k] < heap[k + 1]) {
                k = k + 1;
            }
            if (heap[key] > heap[k])
                break;
            exch(heap, key, k);
            key = k;
        }
    }


    private void swim(int key) {
        //while not at root and greater than parent
        while (key != 1 && heap[key] > heap[(int) Math.floor(key / 2)]) {
            exch(heap, key, (int) Math.floor(key / 2));
            key = (int) Math.floor(key / 2);
        }
    }

    private void exch(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public void insert(int key) {
        this.N++;
        heap[N] = key;
        swim(N);
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i = 1; i <= N; i++) {
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
