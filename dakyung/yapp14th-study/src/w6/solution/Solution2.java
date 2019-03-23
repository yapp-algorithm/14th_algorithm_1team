/**
 * 문제 : 프로그래머스 DFS/BFS 네트워크 - level 3
 * 출처 : https://programmers.co.kr/learn/courses/30/parts/12421
 *
 * 작성일 : 2019.3.22
 * 작성자 : 고다경
 *
 * 문제 설명
 *
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
 * 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 * 제한사항
 * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * computer[i][i]는 항상 1입니다.
 * 입출력 예
 * n	computers	return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 * 입출력 예 설명
 * 예제 #1
 * 아래와 같이 2개의 네트워크가 있습니다.
 * image0.png
 * 예제 #2
 * 아래와 같이 1개의 네트워크가 있습니다.
 * image1.png
 *
 * 결과 :
 * test case 1,4,9 실패
 */
package w6.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    //test case 1 : result 2
//    private static final int n = 3;
//    private static final int[][] computers = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
    // test case 2 : result 1
//    private static final int n = 3;
//    private static final int[][] computers = new int[][]{{1,1,0}, {1,1,1}, {0,1,1}};
    // test case 3 : result 5
//    private static final int n = 5;
//    private static final int[][] computers = new int[][]{{1,0,0,0,0}, {0,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,0}, {0,0,0,0,1}};
    // test case 4 : result 4
    private static final int n = 5;
    private static final int[][] computers = new int[][]{{1,0,0,0,0}, {0,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}, {0,0,0,1,1}};

    public static void main(String[] args){
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        int i = 0;
        while(i < n) {
            i += BFS(n, computers, i);
            answer++;
        }

        return answer;
    }

    private static int BFS(int n, int[][] computers, int startIndex) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> nextVisitList = new LinkedList<>();

        visited.add(startIndex);
        nextVisitList.add(startIndex);

        int i = startIndex;
        int lastIndex = 0;

        while (nextVisitList.isEmpty() == false) {
            int now = nextVisitList.remove();
//            int[] adjacentVertexList = computers[now];

            for (int j = startIndex; j < n; j++) {
//                if (i != j && visited.contains(j) == false && adjacentVertexList[j] == 1) {
                if (i != j && visited.contains(j) == false && computers[now][j] == 1) {
                    visited.add(j);
                    nextVisitList.add(j);
                }
            }
            i++;
            lastIndex++;
        }
        return lastIndex;
    }
}
