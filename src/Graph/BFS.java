package Graph;

import java.util.*;

public class BFS {
    public void bfs(Map<String,List<String >> graph,String src){
        Queue<String> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            String curr = queue.poll();
            System.out.println(curr);
//            for (String neighbour : graph.get(curr)){
//                queue.add(neighbour);
//            }
//            Above iteration is removed by using addAll() method of queue.
            queue.addAll(graph.get(curr));

        }
    }

    public void bfsForCyclic(Map<String,List<String>> graph, String src, Set<String> isVisited){
        Queue<String> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            String curr = queue.poll();
            if (isVisited.contains(curr)) continue;
            System.out.println(curr);
            isVisited.add(curr);
            queue.addAll(graph.get(curr));
        }
    }
}
