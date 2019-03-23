package w6.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class DFSLoopPractice {
    public static HashMap<Character, String> createGraph() {
        HashMap<Character, String> graph = new HashMap<>();
        graph.put('A', "BFH");
        graph.put('B', "ACEF");
        graph.put('C', "ABDE");
        graph.put('D', "CE");
        graph.put('E', "BCD");
        graph.put('F', "ABHG");
        graph.put('G', "FH");
        graph.put('H', "AF");
        return graph;
    }

    public static void DFS(HashMap<Character, String> graph, char start){
        HashSet<Character> visited = new HashSet<>(); // 방문한 목록
        Stack<Character> nextVisitList = new Stack<>(); // 다음에 방문할 정점 목록
                                                        // Stack으로 저장시 DFS, Queue로 저장시 BFS

        visited.add(start);
        nextVisitList.push(start);

        while(nextVisitList.isEmpty() == false){
            char now = nextVisitList.pop(); //
            System.out.printf("%c ", now);
            String adjacentList = graph.get(now);
            for(char adjacent : adjacentList.toCharArray()){
                if(visited.contains(adjacent) == false) {
                    visited.add(adjacent);
                    nextVisitList.add(adjacent);
                }
            }
        }
    }

    public static void main(String[] args){
        DFS(createGraph(), 'A');
    }
}
