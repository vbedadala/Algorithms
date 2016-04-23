package sorting;

import heap.IndexMinHeap;

/**
 * Created by vasantbedadala on 4/7/16.
 *
 * merge K sorted arrays
 * Solution : Use Indexed priority queue
 */
public class KWayMerge {

    public int[] kmerge(int[] ... sorted){

        IndexMinHeap pq = new IndexMinHeap(100);
        int[] counter = new int[sorted.length];

       for(int i=0; i<sorted.length; i++) {
           pq.insert(i+1,sorted[i][0]);
           counter[i]++;
       }

       while (!pq.isEmpty()) {
           int x = pq.minIndex()-1;
           System.out.println(pq.delMin());
           if(counter[x] !=sorted[0].length) {
               pq.insert(x+1, sorted[x][counter[x]]);
               counter[x]++;
           }
       }

        return null;
    }


}
