/*
 * 문제 : 프로그래머스 정렬 level3 - H-Index 
 * 출처 : https://programmers.co.kr/learn/courses/30/parts/12198
 * 
 * 작성일 : 2019.2.2 
 * 작성자 : 고다경 
 */
package w1.solution;

// 데이터 개수는 항상 홀수 ( h개 이상, h개 이하) 
// 2, 2, 4, 6, 7 -> 4번 이상 인용된 논문 3편이상, 나머지 논문 2편이상 

public class Solution3 {
	
	private static final int[] CITATIONS = new int[]{3, 0, 6, 1, 5};
//	private static final int[] CITATIONS = new int[]{0,0,0};
	
	public static void main(String[] args) {
		System.out.println(solution(CITATIONS));
	}
			
	public static int solution(int[] citations) {
		int answer = 0;
        
        citations = sort(citations);

        for(int i=0; i<citations.length; i++){
        	if(citations[i] > i) answer++; 
        }
       
        return answer;
    }
	
	private static int[] sort(int[] citations){
		int key;
		for(int i=1; i<citations.length; i++){
			key = citations[i];
			int j;
			for(j = i-1; j>=0; j--){
				if(citations[j] > key) break;
				citations[j+1] = citations[j];
			}
			citations[j+1] = key;
		}
		return citations;
	}
}
