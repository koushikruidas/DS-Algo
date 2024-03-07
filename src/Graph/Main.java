package Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdgeDirected(0, 1);
        graph.addEdgeDirected(0, 2);
        graph.addEdgeDirected(1, 2);
        graph.addEdgeDirected(2, 0);
        graph.addEdgeDirected(2, 3);
        graph.addEdgeDirected(3, 3);

//        for (List<Integer> adjs : graph.getAdj()){
//            for (int val : adjs){
//                System.out.print(val+", ");
//            }
//            System.out.println();
//        }
        List<List<String>> edges = List.of(
                List.of("i", "j"),
                List.of("k", "i"),
                List.of("m", "k"),
                List.of("k", "l"),
                List.of("o", "n")
        );
        Map<String, List<String>> undirectedGraph = graph.buildUndirectedGraphFromEdges(edges);
        Map<String,List<String>> directedGraph = graph.buildDirectedGraphFromEdges(edges);

        /*System.out.println("========Undirected Graph=========");
        for (Map.Entry entry : undirectedGraph.entrySet()){
            System.out.print(entry.getKey()+": ");
            for (String adj : (List<String>)entry.getValue()){
                System.out.print(adj+", ");
            }
            System.out.println();
        }
        System.out.println("========Directed Graph=========");
        for (Map.Entry entry : directedGraph.entrySet()){
            System.out.print(entry.getKey()+": ");
            for (String adj : (List<String>)entry.getValue()){
                System.out.print(adj+", ");
            }
            System.out.println();
        }*/

        Map<String, List<String>> graph1 = Map.of(
                "a", List.of("c", "b"),
                "b", List.of("d"),
                "c", List.of("e"),
                "d", List.of("f"),
                "e", List.of(),
                "f", List.of()
        );

//        BFS bfs = new BFS();
//        bfs.bfs(graph1,"a");
//        System.out.println("Starting DFS");
//        DFS dfs = new DFS();
//        dfs.dfsRec(graph1,"a");

        Map<String, List<String>> graph2 = Map.of(
                "f", List.of("g", "i"),
                "g", List.of("h"),
                "h", List.of(),
                "i", List.of("g", "k"),
                "j", List.of("i"),
                "k", List.of()
        );
        HasPath hasPath = new HasPath();
        /*System.out.println(hasPath.hasPathBfs(graph2,"f","k")); // true
        System.out.println(hasPath.hasPathBfs(graph2,"f","j")); // false
        System.out.println(hasPath.hasPathBfs(graph2,"i","h")); // true*/

        BFS bfs = new BFS();
//        bfs.bfsForCyclic(undirectedGraph, "f", new HashSet<>());
//        System.out.println("dfs for cyclic");
        DFS dfs = new DFS();
        dfs.dfsRecForCyclic(graph2,"f",new HashSet<>(),new HashSet<>());


        String str = "Koushik Ruidas";
        Arrays.stream(str.split("")).map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> !i.getKey().equals(" "))
                .filter(i -> i.getValue() > 1)
                .findFirst()
                .ifPresent(System.out::println);
//                .forEach(i -> System.out.println(i.getKey() + "->" + i.getValue()));
        Consumer<String> consumer = System.out::println;
        Predicate<Integer> greaterThan = (i) -> i > 9 ;
        System.out.println(greaterThan.test(10));
        Supplier<String> name = () -> "koushik";
        System.out.println(name.get());
        Function<Integer,Integer> len = i -> i*i;
        System.out.println(len.apply(10));

    }
}
