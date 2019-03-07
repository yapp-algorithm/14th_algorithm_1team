package w2.practice;

import java.util.Arrays;

public class HeapSort {
	static void swap(int[]a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void buildHeap(int[] a){
		int end = a.length - 1;
		for(int i = end / 2; i >= 0; --i)
			heapify(a, i, end);
	}
	
	static void heapify(int[] a, int k, int end){
		// 인덱스 k의 왼쪽 자식 인덱스 = 2k + 1
		// 인덱스 k의 오른쪽 자식 인덱스 = 2k + 2
		int left = 2 * k + 1, right = 2 * k +2;
		int smaller;
		
		// 완전 이진 트리는 자식이 없거나, 왼쪽만 있거나, 둘다 있거나 
		// (1) 두 자식이 있는 경우 : 왼쪽자식인덱스 < 오른쪽자식인덱스 <=마지막 인덱스
		// (2) 왼쪽 자식만 있는 경우 : 왼쪽 <= 마지막 < 오른쪽
		// (3) 자식이 없는 경우 : 마지막 < 왼쪽 < 오른쪽 
		if(right <= end) 
			smaller = (a[left] < a[right]) ? left : right;
//			smaller = (a[left] > a[right]) ? left : right;
		else if (left <= end) smaller = left;
		else return;
		
		if(a[smaller] < a[k]) {
//		if(a[smaller] > a[k]) {
			swap(a, smaller, k);
			heapify(a, smaller, end);
		}
	}
	
	static void heapSort(int[] a) {
		buildHeap(a);
		for(int end = a.length - 1; end >= 1; --end) {
			swap(a, 0, end);
			heapify(a, 0, end - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 3,8,2,10,4,6,7,1,9,5};
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}
}
