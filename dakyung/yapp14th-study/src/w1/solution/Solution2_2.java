/*
 * 문제 : 프로그래머스 정렬 level2 - 가장 큰 수 
 * 출처 : https://programmers.co.kr/learn/courses/30/parts/12198
 * 
 * 작성일 : 2019.2.2 
 * 작성자 : 고다경 
 * 
 * ** 일부 시간 초과 
 */

package w1.solution;

public class Solution2_2{

//	private static final int[] NUMBERS = new int[]{3, 30, 34, 5, 9};
//	private static final int[] NUMBERS = new int[]{0, 0, 0};
//	private static final int[] NUMBERS = new int[]{12,121}; // 12121
//	private static final int[] NUMBERS = new int[]{21, 212}; // 21221
	private static final int[] NUMBERS = new int[]{0,0,70}; 
	
	public static void main(String[] args) {
		System.out.println(solution(NUMBERS));
	}

	public static String solution(int[] numbers) {
		StringBuilder builder = new StringBuilder();
		int key;
		
		for(int i=1; i<numbers.length; i++){
			key = numbers[i];
			
			int j;
			for(j=i-1; j>=0; j--){
				if(compare(numbers[j], key)) break;
				numbers[j+1] = numbers[j];
			}
			numbers[j+1] = key;
		}
		
		if(numbers[0] == 0) return "0";
		
		for(int num : numbers)
			builder.append(num);
		
        return builder.toString();
	}
	
	private static boolean compare(int num1, int num2){
		StringBuilder builder = new StringBuilder();
		String ab = builder.append(num1).append(num2).toString();
		builder = new StringBuilder();
		String ba = builder.append(num2).append(num1).toString();
		
//		if(Integer.parseInt(ab) > Integer.parseInt(ba)) return true;
		if(ab.compareTo(ba) > 0) return true;
		return false;
	}
}
