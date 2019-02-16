import java.util.Scanner;

public class InsertionSort {
	
	/*
	 * 삽입정렬
	 * Key값과 정렬된 배열이 주어졌을 때,
	 * Key값을 정렬된 배열의 알맞는 자리에 삽입하여 정렬하는 방법
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] = scan.nextInt();
		}
		
		InsertSort(array);
		
		for(int i:array) System.out.print(i);
		
		scan.close();
	}
	
	public static void InsertSort(int[] array) {
		for(int i=1;i<array.length;i++) { //주어진 값들 중에서 2번째 값부터 Key값으로 선정
			int key = array[i]; 		  //i번째 수를 Key값으로 설정
			int j = i-1; 				  //Key값을 기준으로 왼쪽에 있는 수부터 비교
			while(j>=0 && array[j]>key) { //맨앞까지 비교했거나 key값이 왼쪽수보다 작으면 순회를 멈춤
				array[j+1] = array[j];    //비교한 값을 오른쪽으로 한칸 이동
				--j; 
			}
			array[j+1] = key; 			  //알맞는 key값의 위치에 저장
		}
	}
}