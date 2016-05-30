package disjointSet;

import java.util.HashMap;

/**
 * Created by vasantbedadala on 4/24/16.
 */
public class UnionFind<E>{

    private int[] ds;
    private HashMap<E,Integer> elementToDSMapping;
    private int[] rank;

    public UnionFind( Object[] elements) {
        ds = new int[elements.length];
        rank= new int[elements.length];
        elementToDSMapping = new HashMap<>();

        for(int i=0; i < elements.length ; i++) {
            ds[i]=i;
            rank[i]=1;
            elementToDSMapping.put((E)elements[i],i);
        }
    }

    public boolean connected(E x, E y) {
        if(!elementToDSMapping.containsKey(x) || !elementToDSMapping.containsKey(y)) {
            return false;
        }
        return root(elementToDSMapping.get(x))==root(elementToDSMapping.get(y));
    }

    public void union(E x, E y) {
        if(!elementToDSMapping.containsKey(x) || !elementToDSMapping.containsKey(y)) {
            return;
        }
        int r1 = root(elementToDSMapping.get(x));
        int r2 = root(elementToDSMapping.get(y));
        if(r1 == r2) {
            return;
        }
        if(rank[r1]<rank[r2]) {
            ds[r1]=r2;
            rank[r2]+=rank[r1];
        }
        else {
            ds[r2]=r1;
            rank[r1]+=rank[r2];
        }
    }

    private int root(int x) {
            int r=x;
            while(ds[r]!=r) {
            r=ds[r];
            }

            while (x!=r) {
               int newx=ds[x];
                ds[x]=r;
                x=newx;

            }

        return r;
    }


}
