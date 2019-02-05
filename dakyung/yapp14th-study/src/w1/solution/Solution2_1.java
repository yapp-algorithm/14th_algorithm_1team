/*
 * 문제 : 프로그래머스 정렬 level2 - 가장 큰 수 
 * 출처 : https://programmers.co.kr/learn/courses/30/parts/12198
 * 
 * 작성일 : 2019.2.2 
 * 작성자 : 고다경 
 * 
 * ** 풀이 중단 
 */
package w1.solution;

public class Solution2_1 {

	private static final int[] NUMBERS = new int[]{3, 30, 34, 5, 9};
	
	public static void main(String[] args) {
		System.out.println(solution(NUMBERS));
	}
	
	public static String solution(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        String[] temp = arraysToStringArr(numbers);
        String key;
        int keyIndex = 0;
        
        // insert sort
        for(int i=1; i<temp.length; i++){
        	key = temp[i];
        	
        	int j;
        	for(j=i-1; j>=0; j--){
        		// (1) 앞자리 비교 
        		if(temp[j].charAt(0) < key.charAt(0)){
        			temp[j+1] = temp[j];
        			keyIndex = j;
        		}
        		// (2) 앞자리 같으면서 자리수가 다른 경우
        		else if(temp[j].charAt(0) == key.charAt(0) && temp[j].length() != key.length()){
        			if(temp[j].length() > key.length()){
        				temp[j+1] = temp[j];
        				keyIndex = j;
        			}
        		}
        		// (3) 앞자리 같으면서 자리수가 같은 경우 
        		else if(temp[j].charAt(0) == key.charAt(0) && temp[j].length() == key.length()){
        			for(int k=1; k<key.length(); k++){
        				if(temp[j].charAt(k) < key.charAt(k)){
        					temp[j+1] = temp[j];
        					keyIndex = j;
        				}
        			}
        		}
        		j--;
        	}
        	temp[keyIndex] = key;
        }
        
        for(String s:temp)
        	builder.append(s);
        
        return builder.toString();
    }
	
	private static String[] arraysToStringArr(int[] numbers){
		int size = numbers.length;
		String[] temp = new String[size];
		for(int i=0; i<size; i++){
			temp[i] = String.valueOf(numbers[i]);
		}
		return temp;
	}
	
}
