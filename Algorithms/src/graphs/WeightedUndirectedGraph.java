package graphs;

import disjointSet.UnionFind;
import heap.IndexMinHeap;
import heap.MinHeap;

import java.util.*;

/**
 * Created by vasant on 5/22/16.
 */
public class WeightedUndirectedGraph{

    private Map<Integer,LinkedList<WeightedEdge>> nodeAdjacency;

    private boolean[] visited;

    private int[] edgeTo;

    private double[] distTo;


    private HashMap<String,Integer> nodeLookup;


    private List<WeightedEdge> mst;

    private List<WeightedEdge> allEdges;

    IndexMinHeap<Double> pqSp = new IndexMinHeap<>(nodeAdjacency.keySet().size());



    public WeightedUndirectedGraph(String ... nodes) {

        nodeAdjacency = new LinkedHashMap<>();
        nodeLookup = new LinkedHashMap<>();
        int i=0;
        for(String node : nodes) {
            nodeAdjacency.put(i,new LinkedList<>());
            nodeLookup.put(node, i);
            i++;
        }

    }

    public void addEdge( String node1,String node2,Double weight) {
        int v= nodeLookup.get(node1);
        int w = nodeLookup.get(node2);
        WeightedEdge e=new WeightedEdge(v,w,weight);
        if(!nodeAdjacency.containsKey(v)) {
            nodeAdjacency.put(nodeLookup.get(v), new LinkedList<>());
        }
        if(!nodeAdjacency.containsKey(w)) {
            nodeAdjacency.put(nodeLookup.get(w), new LinkedList<>());
        }

        nodeAdjacency.get(v).add(e);
        nodeAdjacency.get(w).add(e);
        allEdges.add(e);
    }

   private void visit(int v) {
       visited[v]=true;
   }

    public void dfsVisit(int v) {
        visit(v);

        for(WeightedEdge e : nodeAdjacency.get(v)) {
            int w = e.other(v);
            if(!visited[nodeLookup.get(w)]){
                visit(w);
                edgeTo[nodeLookup.get(w)]=nodeLookup.get(v);
                dfsVisit(w);
            }

        }

    }

    public void dfs(){
        for(int v : nodeAdjacency.keySet()){
            if(visited[nodeLookup.get(v)]){
                dfsVisit(v);
            }
        }
    }


    public void bfsVisit(int v) {
        LinkedList<Integer> queue = new LinkedList<>();
        visit(v);
        queue.add(v);
        while(!queue.isEmpty()) {
             v = queue.getFirst();
             for(int w : nodeAdjacency.keySet()){
                 if(visited[nodeLookup.get(w)]){
                     queue.add(w);
                     visit(w);
                     edgeTo[nodeLookup.get(w)]=nodeLookup.get(v);
                 }
             }
        }

    }

    public void bfs(){
        for(int v : nodeAdjacency.keySet()){
            if(visited[nodeLookup.get(v)]){
                bfsVisit(v);
            }
        }
    }

    public void resetNodeInfo() {
       edgeTo = new int[nodeLookup.size()];
        distTo=new double[nodeLookup.size()];
        visited=new boolean[nodeLookup.size()];

    }

    public void kruskalMST() {
        MinHeap<WeightedEdge> pq = new MinHeap<>(allEdges.toArray(new WeightedEdge[allEdges.size()]));
        UnionFind uf = new UnionFind(nodeAdjacency.keySet().toArray(new String[nodeAdjacency.keySet().size()]));

        //MST size should be V-1 edges to connect V vertices
        while(!pq.isEmpty() && mst.size()<=nodeAdjacency.keySet().size()-1) {
            WeightedEdge e = pq.delMin();

            if(!uf.connected(e.node1,e.node2)) {
                mst.add(e);
                uf.union(e.node1,e.node2);
            }

        }

    }



    public void primMST() {
        for(int v : nodeAdjacency.keySet()) {
            distTo[v]= Double.POSITIVE_INFINITY;
        }
        pqSp.insert(0,distTo[0]);

        while(!pqSp.isEmpty()) {
            int node =pqSp.minIndex();
            pqSp.delMin();

            for(WeightedEdge edge : nodeAdjacency.get(node)) {
                int adjNode = nodeLookup.get(edge.other(node));
                if(distTo[adjNode] > distTo[node]) {
                    if (!pqSp.containsIndex(adjNode)) {
                        edgeTo[adjNode] = node;
                        pqSp.decreaseKey(adjNode, distTo[node]);
                        }
                        else {
                        pqSp.insert(adjNode,distTo[adjNode]);
                        }
                    }
                }
            }

        //follow edge pointers to get MST

        }


    public void djikstra() {
        //Initialize the distance for each vertex to Infinity
        for(int v : nodeAdjacency.keySet()) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        pqSp.insert(0, distTo[0]);
        while(pqSp.isEmpty()) {
            int node = pqSp.minIndex();
            pqSp.delMin();
            for(WeightedEdge e : nodeAdjacency.get(node)) {
                relax(node,e.other(node),e);
            }

        }
    }


    private void relax(int v, int w, WeightedEdge e) {

        if(distTo[w] > distTo[v] + e.weight) {

            //parent pointer
            edgeTo[w] =v;
            // edge relaxation
            distTo[w] = distTo[v] + e.weight;
            //update PQ
            if(pqSp.containsIndex(w)) {
                pqSp.decreaseKey(w, distTo[w]);
            }
            else {
                pqSp.insert(w,distTo[w]);
            }

        }

    }

}
