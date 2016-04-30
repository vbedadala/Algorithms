package disjointSet;

/**
 * Created by vasantbedadala on 4/24/16.
 */
public class UnionFind {

    private int[] ds;
    private int[] rank;

    public UnionFind(int size) {
        ds = new int[size];
        rank= new int[size];

        for(int i=0; i < size ; i++) {
            ds[i]=i;
            rank[i]=1;
        }
    }

    public boolean connected(int x, int y) {
        return root(x)==root(y);
    }

    public void union(int x, int y) {
        int r1 = root(x);
        int r2 = root(y);
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
