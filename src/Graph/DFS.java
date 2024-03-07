package Graph;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public void dfs(Map<String, List<String>> graph, String src){
        Stack<String> stack = new Stack<>();
        stack.push(src);
        while(!stack.isEmpty()){
            String curr = stack.pop();
            System.out.println(curr);
            stack.addAll(graph.get(curr));
        }
    }

    public void dfsRec(Map<String, List<String>> graph, String src){
        System.out.println(src);
        for (String neighbour : graph.get(src)){
            dfsRec(graph,neighbour);
        }
    }

    public void dfsRecForCyclic(Map<String, List<String>> graph, String src, Set<String> isVisited, Set<String> currentPath){
        if (currentPath.contains(src)){
            System.out.println("cycle detected at node: "+src);
            return;
        }
        if (isVisited.contains(src)) return; // This is to aviod revisting same node
        System.out.println(src);
        isVisited.add(src);
        currentPath.add(src);
        for (String neighbour : graph.get(src)){
            dfsRecForCyclic(graph, neighbour,isVisited,currentPath);
        }
        currentPath.remove(src);
    }
}
