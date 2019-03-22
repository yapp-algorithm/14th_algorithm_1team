package w6.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSPractice {
    public static HashMap<Character, String> createGraph() {
        HashMap<Character, String> graph  = new HashMap<>();
        graph.put('A', "BCD");
        graph.put('B', "AC");
        graph.put('C', "ABDE");
        graph.put('D', "ACFG");
        graph.put('E', "C");
        graph.put('F', "DGH");
        graph.put('G', "DFH");
        graph.put('H', "FG");
        return graph;
    }

    public static void BFS(HashMap<Character, String> graph, char startNode){
        HashSet<Character> visited = new HashSet<>(); // 방문한 정점
        Queue<Character> nextVisitList = new LinkedList<>(); // 다음에 방문할 정점 목록

        visited.add(startNode);
        nextVisitList.add(startNode);

        while(nextVisitList.isEmpty() == false){
            char now = nextVisitList.remove(); // 현재 정점
            System.out.printf("%c ", now);
            String adjacentList = graph.get(now); // 인접 정점 목록
            for(char adjacent : adjacentList.toCharArray()){ // 인접 정점에서 인접 정점 목록 탐색
                if(visited.contains(adjacent) == false) { // 인접 정점 목록의 정점을 방문하지 않았으면
                    visited.add(adjacent); // 방문
                    nextVisitList.add(adjacent); // 방문할 정점 목록에 추가
                }
            }
        }
    }

    public static void main(String[] args){
        BFS(createGraph(), 'A');
    }
}
