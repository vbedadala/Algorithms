package median;

import heap.MaxHeap;
import heap.MinHeap;


import java.util.Arrays;


/**
 * Created by vasantbedadala on 3/31/16.
 * Compute median from stream of integers
 * Use minHeap and maxHeap
 */
public class StreamingMedian {

private int n=0;
    public void median(int[] keys) {
        MinHeap minHeap = new MinHeap(200);
        MaxHeap maxHeap = new MaxHeap(200);


        try {

            Arrays.stream(keys).forEach(p->  {
                        switch(balanceFactor(minHeap,maxHeap)) {
                            case 0:
                                if(!maxHeap.isEmpty() &&p >maxHeap.max()) {
                                    minHeap.insert(p);
                                    System.out.println("Median is " + minHeap.min());

                                }
                                else {
                                    maxHeap.insert(p);
                                    System.out.println("Median is " + maxHeap.max());

                                }
                                break;

                            case -1:
                                if(!maxHeap.isEmpty() && p >maxHeap.max()) {
                                    int x = minHeap.delMin();
                                    maxHeap.insert(x);
                                    minHeap.insert(p);

                                }
                                else{
                                    maxHeap.insert(p);

                                }
                                System.out.println("Median is " + Math.floor(minHeap.min() + maxHeap.max())/2);
                                break;


                            case 1:

                                if(!maxHeap.isEmpty() && p < maxHeap.max()) {
                                    int x = maxHeap.delMax();
                                    minHeap.insert(x);
                                    maxHeap.insert(p);
                                }
                                else{
                                    minHeap.insert(p);

                                }
                                System.out.println("Median is " + Math.floor(minHeap.min() + maxHeap.max())/2);
                                break;
                        }


                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //balance check
    public int balanceFactor(MinHeap left, MaxHeap right) {
        if(left.size()== right.size()) {
            return 0;
        }
        else if(left.size() > right.size()) {
            return -1;
        }
        else  {
            return 1;
        }
    }

}
