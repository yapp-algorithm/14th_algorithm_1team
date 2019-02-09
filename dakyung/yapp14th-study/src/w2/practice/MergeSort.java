package w2.practice;

import java.util.Arrays;

public class MergeSort {
	
	// a 배열에서 start, end 사이의 값을 정렬 
	static void mergeSort(int[] a, int start, int end){
		if(start == end) return; // 정렬할 부분 길이 1이면 그냥 리턴
		
		int middle = (start + end) / 2; // start와 end 중간 지점 계산 
		mergeSort(a, start, middle); // 앞-중간 부분 정렬 위한 재귀 호출 
		mergeSort(a, middle + 1, end); // 중간-뒤 부분 정렬 위한 재귀 호출 
		merge(a, start, middle, end); // 앞,뒤 정렬 병합 
	}
	
	// a 배열에서 앞부분(s~m), 뒷부분(m+1~e)을 병합 
	static void merge(int[] a, int start, int middle, int end){
		int length = end - start + 1; // 병합할 부분의 길이 구함 
		int[] temp = new int[length]; // 병합 결과 임시 저장용 배열 
		int i=0; // 임시 배열에 대한 인덱스 
		int index1 = start; // 앞부분(s~m)에 대한 인덱스 
		int index2 = middle +1; // 뒷부분(m+1~e)에 대한 인덱스 
		
		while(index1 <= middle && index2 <= end){ // 병합할 값이 앞&뒷 부분 모두 남아있으면 
			if(a[index1] < a[index2]) // 앞정렬 뒷정렬 선두 값을 비교해
				temp[i++] = a[index1++]; // 더 작은 값을 임시 배열에 넣는다
			else
				temp[i++] = a[index2++];
		}
		
		while(index1 <= middle) // 앞부분 배열 남아있는 값을 임시 배열에  
			temp[i++] = a[index1++];
		while(index2 <= end) // 뒷부분 배열 남아있는 값을 임시 배열에 
			temp[i++] = a[index2++];
		for(i=0; i<temp.length; ++i) // 임시 배열의 내용을 a배열 start 위치로 복사 
			a[start+i] = temp[i];
	}
	
	public static void main(String[] args){
		int[] a = {31, 3, 65, 73, 8, 11, 20, 29, 48, 15};
		
		mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
