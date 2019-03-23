package w6.practice;

import java.util.HashMap;
import java.util.HashSet;

public class DFSRecursivePractice {
    public static HashMap<Character, String> createGraph(){
        HashMap<Character, String> graph = new HashMap<>();
        graph.put('A', "BFH");
        graph.put('B', "ACEF");
        graph.put('C', "BDE");
        graph.put('D', "CE");
        graph.put('E', "BCD");
        graph.put('F', "ABGH");
        graph.put('G', "F");
        graph.put('H', "AF");
        return graph;
    }

    public static void DFS(HashMap<Character, String> graph, char start){
        DFS(graph, start, new HashSet<>());
    }

    private static void DFS(HashMap<Character, String> graph, char now, HashSet<Character> visited){
        visited.add(now); // HashSet에 방문 기록
        System.out.printf("%c ", now);

        String adjacentList = graph.get(now);
        for(char adjacent : adjacentList.toCharArray()){ // 인접 정점 리스트에
            if(visited.contains(adjacent) == false) // 인접 정점이 방문한 정점이 아닌 경우
                // DFS는 Recursive 구현 가능
                DFS(graph, adjacent, visited);
        }
    }

    public static void main(String[] args){
        DFS(createGraph(), 'A');
    }
}
