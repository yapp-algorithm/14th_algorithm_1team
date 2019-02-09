package w2.practice;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	static void swap(int[] a, int i, int j){
		int temp  = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int partition(int[] a, int start, int end){
		// 1구역 : 기준값 보다 작거나 같은
		// 2구역 : 기준값 보다 큰 
		// 3구역 : 아직 정렬되지 않은 
		
		int value = a[end]; // 기준 값 = 배열의 끝 값 
		int i = start - 1; // i는 1구역 끝지점 
		for(int j = start; j <= end - 1; ++j) // j는 3구역 시작 지점 
			if(a[j] < value) // a[j]가 1구역에 속하면  
				swap(a, ++i, j); // a[j]값을 1구역 끝에 추가 
		swap(a, i+1, end); // 기준값인 a[end] 원소와 2구역 시작 원소를 교환 
		return i+1; // 기준값 위치 리턴 
	}
	
	static void quickSort(int[] a, int start, int end){
		if(start >= end) return;
		int middle = partition(a, start, end); // 배열 나누기 
		quickSort(a, start, middle-1); // 1구역 정렬 
		quickSort(a, middle+1, end); // 2구역 정렬 
	}
	
	public static void main(String[] args){
		Random random = new Random();
		int[] a = new int[10];
		for(int i=0; i<a.length; i++)
			a[i] = random.nextInt(20);
		
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
