package heap;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class MaxHeap {
    int[] heap;
    int size;

    public MaxHeap(int size) {
        heap = new int[size + 1];
        this.size=size;
    }

    /**
     * Build heap from bottom up -- maxheapify
     * Leaves are good as they are 1 element heaps, so start with N/2
     * O(n)
     */
    public MaxHeap(int[] keys) {
        heap = new int[keys.length +1];
        size=keys.length;
        //start with index 1, to avoid null links
        for(int i=0; i<keys.length; i++) {
            heap[i+1]=keys[i];
        }
        for (int i = size / 2; i >= 1; i--) {
            sink(i);
        }
    }

    public int max() {
        return heap[1];
    }

    public int delMax() {
        int max=heap[1];
        exch(heap,1,size--);
        sink(1);
        return max;
    }

    private boolean isMaxHeap(int k) {
        int left = 2*k;
        int right = 2*k+1;
        if(heap[k]<=left) return false;
        if(heap[k]<=right) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }

    private void sink(int key) {
        while (2 * key < size) {
            int k = 2 * key;
            if (heap[k] < heap[k + 1]) {
                k = k + 1;
            }
            if (heap[key] < heap[k])
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
        if(heap.length-1 >=size) {
            resize(2*heap.length);
        }
        size++;
        heap[size]=key;
        swim(key);
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > size;
        int[] temp = new int[capacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

}
