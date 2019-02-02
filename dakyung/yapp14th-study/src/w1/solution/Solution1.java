/*
 * 문제 : 프로그래머스 정렬 level1 - K번째 수 
 * 출처 : https://programmers.co.kr/learn/courses/30/parts/12198
 * 
 * 작성일 : 2019.2.2 
 * 작성자 : 고다경 
 */
package w1.solution;

public class Solution1 {
	
	private static final int[] ARRAY = new int[]{1, 5, 2, 6, 3, 7, 4};
	private static final int[][] COMMANDS = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
	
	public static void main(String[] args) {
		for(int value : solution(ARRAY, COMMANDS))
			System.out.printf("%d ", value);
		
		for(int value : solution2(ARRAY, COMMANDS))
			System.out.printf("%d ", value);

	}
	
	// java collection 
	public static int[] solution2(int[] array, int[][] commands){
		int[] answer = {};
		return answer;
	}
	
	// basic 
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int a=0; a<commands.length; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] temp = new int[j-i+1];
            for(int b=0; b<j-i+1; b++)
                temp[b] = array[b+i-1];
            
            temp = insertSort(temp);
            answer[a] = temp[k-1];
        }
        return answer;
    }
	
	private static int[] insertSort(int[] temp){
        int key;
        for(int i=1; i<temp.length; i++){
            key = temp[i];
            
            int j=i-1;
            while(j>=0 && temp[j] > key){
                temp[j+1] = temp[j];
                j--;
            }
            temp[j+1] = key;
        }
        return temp;
    }
}
