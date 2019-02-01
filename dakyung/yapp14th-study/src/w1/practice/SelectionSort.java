package w1.practice;

// 저장되어 있는 자료로부터 K번째로 큰, 또는 작은 값을 찾는 정렬 
// 최소값, 최대값 또는 중간값을 찾는 알고리즘
// (1) 정렬 알고리즘을 이용해 정렬
// (2) 원하는 순서에 있는 자료 가져오기 


public class SelectionSort {
	
	private static final int SIZE = 5;
	
	private static Integer[] selectionSort(Integer[] arr, int size){
		int min;
		Integer temp;
		
		for(int i=0; i< size-1; i++){
			StringBuilder builder = new StringBuilder();
			min = i;
			for(int j=i+1; j<size; j++){
				if(arr[j] < arr[min]) min = j;
			}
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
			RandomArrayUtils.arrayPrint(builder.append("> ").append(i+1).toString(), arr);
		}
		
		return arr;
	}

	public static void main(String[] args) {
		Integer[] arr = RandomArrayUtils.integerArrayCreate(SIZE);
		RandomArrayUtils.arrayPrint("랜덤값 배열 생성",arr);
		
		RandomArrayUtils.arrayPrint("선택 정렬 후",selectionSort(arr, SIZE));
	}
}
