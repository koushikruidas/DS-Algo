package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HasPath {

    // solving with dfs
    public boolean hasPath(Map<String, List<String>> graph, String src, String dest){
        if (src.equals(dest)) return true;
        for (String neighbour : graph.get(src)){
            if ( hasPath(graph,neighbour,dest) ){
                return true;
            }
        }
        return false;
    }

    // solving with bfs
    public boolean hasPathBfs(Map<String, List<String>> graph, String src, String dest){
        Queue<String> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            String curr = queue.poll();
            if (curr.equals(dest)) return true;
            queue.addAll(graph.get(curr));
        }
        return false;
    }
}
