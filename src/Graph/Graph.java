package Graph;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adj;

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }

    public Graph(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[this.vertices];
        for (int i = 0; i < this.vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdgeDirected(int a, int b){
        adj[a].add(b);
    }

    public void addEdgeUndirected(int a, int b){
        adj[a].add(b);
        adj[b].add(a);
    }

    public void removeEdgeDirected(int a, int b){
        adj[a].remove(b);
    }

    public void removeEdgeUndirected(int a, int b){
        adj[a].remove(b);
        adj[b].remove(a);
    }

    public Map<String,List<String>> buildUndirectedGraphFromEdges(List<List<String>> edges){
        Map<String,List<String>> graph = new HashMap<>();
        for (List<String> edge : edges){
            String a = edge.get(0);
            String b = edge.get(1);
            if (!graph.containsKey(a)) graph.put(a,new ArrayList<>());
            if (!graph.containsKey(b)) graph.put(b,new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }

    public Map<String,List<String>> buildDirectedGraphFromEdges(List<List<String>> edges){
        Map<String,List<String>> graph = new HashMap<>();
        for (List<String> edge : edges){
            String a = edge.get(0);
            String b = edge.get(1);
            if (!graph.containsKey(a)) graph.put(a,new ArrayList<>());
            if (!graph.containsKey(b)) graph.put(b,new ArrayList<>());
            graph.get(a).add(b);
        }
        return graph;
    }
}
