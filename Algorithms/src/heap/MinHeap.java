package heap;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class MinHeap {
    int[] heap;
    int size;
    int N;

    public MinHeap(int size) {
        heap = new int[size + 1];
        this.size = size;
        this.N=0;
    }

    /**
     * Build heap from bottom up -- minheapify
     * Leaves are good as they are 1 element heaps, so start with N/2
     * O(n)
     */
    public MinHeap(int[] keys) {
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

    public int min() {
        if(!isEmpty()) {
            return heap[1];
        }
        return -1;
    }

    public int delMin() {
        if(!isEmpty()) {
            int min = heap[1];
            exch(heap, 1, N--);
            sink(1);
            return min;
        }
        return -1;
    }

    private boolean isMinHeap(int k) {
        int left = 2 * k;
        int right = 2 * k + 1;
        if (heap[k] >= left) return false;
        if (heap[k] >= right) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    private void sink(int key) {
        while (2 * key <=N) {
            int k = 2 * key;
            if (k<N && heap[k] > heap[k + 1]) {
                k = k + 1;
            }
            if (heap[key] < heap[k])
                break;
            exch(heap, key, k);
            key = k;
        }
    }


    private void swim(int key) {
        //while not at root and less than parent
        while (key != 1 && heap[key] < heap[(int) Math.floor(key / 2)]) {
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
//        if (heap.length - 1 >= size) {
//            resize(2 * heap.length);
//        }

        this.N++;
        heap[N] = key;
        swim(N);
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        int[] temp = new int[capacity];
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
