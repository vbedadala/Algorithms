package graphs;

import java.util.*;

/**
 * Created by vasant on 12/4/15.
 *
 */
public class UndirectedGraph {

    private List<Integer>[] adjList;

    private boolean[] visited;

    private HashMap<String,Integer> vertices = new HashMap<>();

    private int[] edgeTo;

    private int[] component;

    private boolean[] color;

    private int v;

    private boolean cycleFound;

    private boolean isBiPartite=true;


    public UndirectedGraph(int v) {
        this.v = v;
        this.visited = new boolean[v];
        this.edgeTo = new int[v];
        this.adjList = new List[v];
        this.component = new int[v];
        this.color = new boolean[v];
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

    public UndirectedGraph(int v,List<String> vnames) {
        this.v = v;
        this.visited = new boolean[v];
        this.edgeTo = new int[v];
        this.adjList = new List[v];
        this.component = new int[v];
        this.color = new boolean[v];
        for (int i=0; i < v; i++) {
            vertices.put(vnames.get(i),i);
        }
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
        adjList[w].add(v);
    }



    public int vindex(String name) {
        return vertices.get(name);
    }

    public void dfs(int v) {
        visit(v);
        for(int x : adj(v)) {
            if(!visited[x]) {
                edgeTo[x]=v;
                dfs(x);
            }
        }
    }

    public void dfsWithCC(int v, int count) {
        visit(v);
        component[v] = count;
        for(int x : adj(v)) {
            if(!visited[x]) {
                System.out.println(x + " connected component " +  count);
                dfsWithCC(x,count);
            }
        }
    }

    public boolean dfsCycle(int v, int u) {
        if(cycleFound) {
            return true;
        }
        visit(v);

        for (int w : adj(v)) {
            if (!visited[w]) {
                edgeTo[w] =v;
                dfsCycle(w, v);
            }
            else {
                if (w !=u & !cycleFound) {
                    System.out.println("cycleFound  +" +  u);
                    pathTo(v,w);
                    this.cycleFound=true;
                    return true;

                }
            }
        }
        return false;
    }


    public void printParentPointers() {
        for (int i = 0; i < edgeTo.length; i++) {
            System.out.println(i);
        }
    }

    public void reset() {
        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = -1;
            visited[i] = false;
        }
    }

    private void visit(int v) {
        System.out.print(v + " ");
        visited[v]=true;
    }

    public void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        visit(v);
        while (!queue.isEmpty()) {
            int w = queue.remove();
            for (int x : adj(w)) {
                if(!visited[x]) {
                    visit(x);
                    edgeTo[x] = w;
                    queue.add(x);
                }
            }
        }
    }


    public void cc() {
        int count = 0;
        for (int i = 0; i < v; i++) {
            if(!visited[i]) {
                count++;
                dfsWithCC(i, count);
            }
        }
    }

    public void pathTo(int t, int s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = t; i != s; i = edgeTo[i]) {
            if(i==-1) {
                System.out.println("path does not exist");

            }
            stack.push(i);
        }
        System.out.println();

        stack.push(s);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    //verify back edges in DFS Forrest
    public boolean hasCycle() {
        this.cycleFound=false;
        for (int i = 0; i < v; i++) {
            //create DFS trees for each vertex

            if (!visited[i] && dfsCycle(i, -1)) {
                return true;
            }
        }

        return false;
    }

    private void dfsColor(int v) {
        visit(v);
        for(int w : adj(v)) {
            if(cycleFound){
                return;
            }
            if(!visited[w]){
                color[w]=!color[v];
                edgeTo[w]=v;
                dfsColor(w);
            }
            else if(color[w]==color[v]) {
                isBiPartite=false;
                cycleFound=true;

                pathTo(v,w);
                return;
            }
        }

    }

    public boolean isBiPartite() {

        for (int i=0; i < v; i ++) {
            if(!visited[i] ){
                dfsColor(i);
            }
            else {
                return false;
            }
        }
        return isBiPartite;
    }

    public boolean connected(int x, int y) {
        return component[x]==component[y];
    }




}