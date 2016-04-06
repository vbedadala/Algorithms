package graphs;

import java.util.*;

/**
 * Created by vasant on 12/4/15.
 */
public class UndirectedGraph {

    private List<Integer>[] adjList;

    private boolean[] marked;

    private int[] edgeTo;

    private int[] component;

    private int v;

    public UndirectedGraph(int v) {
        this.v = v;
        this.marked = new boolean[v];
        this.edgeTo = new int[v];
        this.adjList = new List[v];
        this.component = new int[v];
        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = -1;
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

    public void dfs(int v) {
        marked[v] = true;
        System.out.println(v);
        adj(v).stream().filter(it -> !marked[it]).forEach(it -> {
            edgeTo[it] = v;
            marked[it] = true;
            dfs(it);
        });
    }

    public void dfsWithCC(int v, int count) {
        marked[v] = true;
        component[v] = count;
        System.out.println(v);
        adj(v).stream().filter(it -> !marked[it]).forEach(it -> {
            edgeTo[it] = v;
            marked[it] = true;
            dfs(it);
        });
    }

    public boolean dfsCycle(int v, int u) {
        marked[v] = true;
        for (int w : adj(v)) {
            if (!marked[w]) {
                if (w == u) {
                    return true;
                }
                marked[w] = true;
                dfsCycle(w, u);
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
            marked[i] = false;
        }
    }

    public void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        marked[v] = true;
        while (!queue.isEmpty()) {
            int w = queue.remove();
            System.out.println(w);
            adj(w).stream().filter(it -> !marked[it]).forEach(it -> {
                marked[it] = true;
                edgeTo[it] = w;
                queue.add(it);
            });

        }
    }

    public void cc() {
        int count = 0;
        for (int i = 0; i < v; i++) {
            count++;
            dfsWithCC(i, count);
        }
    }

    public void pathTo(int t, int s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = t; i != s; i = edgeTo[i]) {
            stack.push(i);
        }
        stack.push(s);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


    public void hasCycle() {
        for (int i = 0; i < v; i++) {
            if (dfsCycle(i, i)) {
                System.out.println("Cycle found");
                break;
            }
        }

    }
}