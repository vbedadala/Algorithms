package graphs;

import disjointSet.UnionFind;
import heap.IndexMinHeap;
import heap.MinHeap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by vasant on 5/22/16.
 */
public class WeightedDirectedGraph {

    private Map<Integer,LinkedList<WeightedEdge>> nodeAdjacency;

    private boolean[] visited;

    private int[] edgeTo;

    private double[] distTo;


    private List<WeightedEdge> mst;

    private List<WeightedEdge> allEdges;

    private Stack<Integer> topologicalOrder;

    IndexMinHeap<Double> pqSp = new IndexMinHeap<>(nodeAdjacency.keySet().size());

    PriorityQueue pq = new PriorityQueue();


    /**
     *
     * @param in
     *
     * node1 node2 weight
     * comments with #
     */

    public WeightedDirectedGraph(InputStream in) {
        nodeAdjacency = new LinkedHashMap<>();
        String line="";
        String[] nodes= new String[3];
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))){
            int i = 0;
            while((line=br.readLine())!=null)
                if(!line.startsWith("#"))
                {
                    nodes=line.split(" ");
                    nodeAdjacency.put(Integer.parseInt(nodes[0]), new LinkedList<>());
                    nodeAdjacency.put(Integer.parseInt(nodes[1]), new LinkedList<>());
                    addEdge(Integer.parseInt(nodes[0]),Integer.parseInt(nodes[1]),Double.parseDouble(nodes[3]));
                }
                i++;
        }
        catch(IOException e) {

        }


    }

    public void addEdge( int node1,int node2,Double weight) {

        WeightedEdge e=new WeightedEdge(node1,node2,weight);
        if(!nodeAdjacency.containsKey(node1)) {
            nodeAdjacency.put(node1, new LinkedList<>());
        }
        if(!nodeAdjacency.containsKey(node2)) {
            nodeAdjacency.put(node2, new LinkedList<>());
        }

        nodeAdjacency.get(node1).add(e);
        allEdges.add(e);
    }

   private void visit(int v) {
       visited[v]=true;
   }

    public void dfsVisit(int v) {
        visit(v);

        for(WeightedEdge e : nodeAdjacency.get(v)) {
            int w = e.other(v);
            if(!visited[w]){
                visit(w);
                edgeTo[w]=v;
                dfsVisit(w);
            }

        }

    }

    public void dfs(){
        for(int v : nodeAdjacency.keySet()){
            if(visited[v]){
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
                 if(visited[w]){
                     queue.add(w);
                     visit(w);
                     edgeTo[w]=v;
                 }
             }
        }

    }

    public void bfs(){
        for(int v : nodeAdjacency.keySet()){
            if(visited[v]){
                bfsVisit(v);
            }
        }
    }

    public void resetNodeInfo() {
       edgeTo = new int[nodeAdjacency.keySet().size()];
        distTo=new double[nodeAdjacency.keySet().size()];
        visited=new boolean[nodeAdjacency.keySet().size()];

    }

    /**
     * Greedy algorithm . Always pick the vertex closest to source vertex
     * O(V + ElogV)
     */

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

    private void relaxWithNegativeWeight(int v, int w, WeightedEdge e) {

        if(distTo[w] < distTo[v] + e.weight) {

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


    /**
     * If Directed graph is a "DAG", then we can just relax edges in topological order
     * O(V + ElogV) . If we use Binary heap
     */
    public void shortestPathIfDAG(){

        for(int v: nodeAdjacency.keySet()) {
            distTo[v] =Double.POSITIVE_INFINITY;
        }

        for(int v: topologicalOrder()) {
            for(WeightedEdge e: nodeAdjacency.get(v)) {
                relax(v,e.other(v),e);
            }
        }


    }

    //CRAZY 8's (longest possible subsequence) is example of this.
    public void longestPathIfDAG(){

        for(int v: nodeAdjacency.keySet()) {
            distTo[v] =Double.NEGATIVE_INFINITY;
        }

        for(WeightedEdge w : allEdges) {
            w.weight= -w.weight;
        }

        for(int v: topologicalOrder()) {
            for(WeightedEdge e: nodeAdjacency.get(v)) {
                relaxWithNegativeWeight(v, e.other(v), e);
            }
        }

    }


    public Stack<Integer> topologicalOrder() {
        for(int v: nodeAdjacency.keySet()) {
            if(!visited[v]) {
                dfsTop(v);
            }
        }
        return topologicalOrder;
    }

    public void dfsTop(int v) {
        visit(v);
        for(WeightedEdge e: nodeAdjacency.get(v)){
            int w = e.other(v);
            if(!visited[w]) {
                dfsTop(w);
            }

        }
        topologicalOrder.add(v);
    }

    public void bellmanFord(){

        for(int v: nodeAdjacency.keySet()) {
            distTo[v]=Double.POSITIVE_INFINITY;
        }
        for(int i: nodeAdjacency.keySet()) {
            for (WeightedEdge e : allEdges) {
                relax(e.node1,e.node2,e);
            }
        }

    }

}
