package graphs;

import stack.Queue;
import stack.Stack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vasant on 4/30/16.
 */
public class DirectedGraph {

    private List<Integer>[] adjList;

    private boolean[] visited;

    private int[] edgeTo;

    private int[] component;

    private boolean[] color;

    private int V;

    private int[] indegree;

    private boolean [] onStack;

    private boolean cycleFound=false;

    private Stack<Integer> cycle;

    private Stack<Integer> postOrder;

    public DirectedGraph(int v){
        this.V= v;
        this.visited = new boolean[v];
        this.edgeTo = new int[v];
        this.adjList = new List[v];
        this.component = new int[v];
        this.color = new boolean[v];
        this.onStack = new boolean[v];
        this.indegree = new int[v];
        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = -1;
        }
        for (int i = 0; i < edgeTo.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < v; i++) {
            this.adjList[i] = new LinkedList<>();
        }

    }

    public List<Integer> adj(int v) {
        return adjList[v];
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
        indegree[w]++;
    }

    private void visit(int v) {
        System.out.println(v +" ");

        visited[v]=true;
    }
    public void dfs(int v) {
        visit(v);
        for(int w :adj(v)) {
            if(!visited[w]) {
                edgeTo[w]=v;
                dfs(w);
            }
        }
    }

    public void bfs(int v) {
        Queue<Integer> queue =new Queue<>();
        visit(v);
        queue.insert(v);
        while(!queue.isEmpty()) {
            v =queue.delete();
            for(int w: adj(v)) {
                if(!visited[w]){
                    queue.insert(w);
                    edgeTo[w]=v;
                    visit(v);
                }
            }
        }

    }

    public void idfs(int v) {
        visit(v);
        Stack<Integer> stack = new Stack<>(V);
        stack.push(v);
        while(!stack.isEmpty()) {
            v =stack.pop();
            for (int w : adj(v)) {
                if (!visited[w]) {
                    edgeTo[w] = v;
                    stack.push(w);
                }
            }
        }
    }

    public int indegree(int v) {
        return indegree[v];
    }

    public int outdegree(int v) {
        return adj(v).size();
    }

    public boolean hasCycle() {
        for(int i=0; i< V; i++) {
            if(!visited[i])
             dfs(i);
        }
        if(cycleFound){
            System.out.println("Cycle Found :");
            while(!cycle.isEmpty()){
                System.out.println(cycle.pop());
            }
            return true;
        }
        return false;
    }

    public void dfsCycle(int v){
        visit(v);
        for(int w: adj(v)){
            if(cycleFound){
                return;
            }
            if(!visited[w]) {
                edgeTo[w]=v;
                dfsCycle(v);
            }
            else if(onStack[v]){
                cycleFound=true;
                cycle =pathTo(v,w);
            }
        }
       onStack[v]=false;
    }

    public void dfsTop(int v) {
        visit(v);
        for(int w: adj(v)) {
            if(!visited[v]){
                dfsTop(v);
            }
        }
        postOrder.push(v);
    }

    /**print topological order. It is reverse post order. For any given edge v->w post order
     * give that v is completed after w. reverse post ordeer
     *
     */
    public void topologicalSort() {
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfsTop(i);
            }
        }


    }

    public Stack<Integer> pathTo(int s, int t) {
        Stack<Integer> path = new Stack<>(V);
        for(int i=t; i!=s; i=edgeTo[i]){
            path.push(i);
        }
        return path;
    }

}
