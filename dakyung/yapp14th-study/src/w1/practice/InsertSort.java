package w1.practice;


public class InsertSort {
	
	private static final int SIZE = 5;
	
	private static Integer[] insertSort(Integer[] arr, int size){
		Integer key;
		for(int i=1; i<size; i++){
			StringBuilder builder = new StringBuilder();
			// 삽입할 값 보관 
			key = arr[i]; 
			System.out.printf("> 기준 값 : %d\n" , key);
			
			// 뒤로 이동 
			int j = i-1;
			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j]; 
				j--;
				RandomArrayUtils.arrayPrint("> 뒤로 이동",arr);
			}
			// 값 삽입 
			arr[j+1] = key;
			RandomArrayUtils.arrayPrint(builder.append("> ").append(i).append("회 끝").toString(),arr);
		}
		return arr;
	}

	public static void main(String[] args) {
		Integer[] arr = RandomArrayUtils.integerArrayCreate(SIZE);
		RandomArrayUtils.arrayPrint("랜덤값 배열 생성",arr);
		
		RandomArrayUtils.arrayPrint("삽입 정렬 후",insertSort(arr, SIZE));
	}

}
