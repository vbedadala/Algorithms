package heap;

import java.util.NoSuchElementException;

/**
 * Created by vasantbedadala on 2/15/16.
 */
public class IndexMinHeap<T extends Comparable<T>> {

    //heap positions
    int [] pq;
    //array of keys to heap indexes
    int [] qp;
    Object [] keys;


    int size;
    int N;

    public IndexMinHeap(int size) {
        pq = new int[size + 1];
        qp = new int[size + 1];
        keys = new Object[size +1];
        this.size = size;
        this.N=0;
    }


    public T min() {
        if(!isEmpty()) {
            return(T) keys[pq[1]];
        }
        return null;
    }

    public int minIndex() {
        if(!isEmpty()) {
            //since heap is one indexed
            return pq[1];
        }
        return -1;
    }

    public T delMin() {
        if(!isEmpty()) {
            T min = (T) keys[pq[1]];
            exch( 1, N--);
            qp[pq[1]]=-1;
            sink(1);
                return min;
        }
        return null;
    }

    public T getKey(int i) {
        return (T) keys[i];
    }
    public void changeKey(int i, T key) {
        keys[i]=key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public void decreaseKey(int i, int key) {
       if(!containsIndex(i)) {
           throw new NoSuchElementException("Index not in the priority queue");

       }
        keys[i]=key;    
        swim(qp[i]);
    }

    public void increaseKey(int i, int key) {
        if(!containsIndex(i)) {
            throw new NoSuchElementException("Index not in the priority queue");

        }
        keys[i]=key;
        sink(qp[i]);
    }


    private boolean isMinHeap(int k) {
        int left = 2 * k;
        int right = 2 * k + 1;
        if (((T)keys[pq[k]]).compareTo((T)keys[left])>=0) return false;
        if (((T)keys[pq[k]]).compareTo((T)keys[right])>=0) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    private void sink(int key) {
        while (2 * key <=N) {
            int k = 2 * key;
            if (k<N && ((T)keys[pq[k]]).compareTo((T)keys[pq[k + 1]]) >=1) {
                k = k + 1;
            }
            if (((T)keys[pq[key]]).compareTo((T) keys[pq[k]]) <0)
                break;
            exch(key, k);
            key = k;
        }
    }


    private void swim(int key) {
        //while not at root and less than parent
        while (key != 1 && (((T)keys[pq[key]]).compareTo((T)keys[pq[(int) Math.floor(key / 2)]])<0)) {
            exch(key, (int) Math.floor(key / 2));
            key = (int) Math.floor(key / 2);
        }
    }

    private void exch( int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]]=i;
        qp[pq[j]]=j;

    }



    public void insert(int i,T key) {

        this.N++;
        pq[N] = i;
        qp[i] =N;
        keys[i]=key;
        swim(N);
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        int[] temp = new int[capacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public boolean isEmpty() {
        return this.N==0;
    }

    public int size() {
        return this.N;
    }

    public boolean containsIndex(int index) {
        return qp[index]!=-1;
    }
}
