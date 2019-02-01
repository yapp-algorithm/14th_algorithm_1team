package w1.practice;

public class BubbleSort{
	
	private static final int SIZE = 5;
	private static int count = 0;
	
	private static Integer[] bubbleSort(Integer[] arr, int size){
		Integer temp;
		
		for(int i=size-1; i>0; i--){
			StringBuilder builder = new StringBuilder();
			for(int j=0; j<i; j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				RandomArrayUtils.arrayPrint(builder.append("> ").append(-(i-size)).append("-").append(j+1).toString(), arr);
				count++;
			}
			System.out.println("\n");
		}
		return arr;
	}

	public static void main(String[] args) {
		Integer[] arr = RandomArrayUtils.integerArrayCreate(SIZE);
		RandomArrayUtils.arrayPrint("랜덤값 배열 생성",arr);
		System.out.println();
		
		RandomArrayUtils.arrayPrint("정렬 후 배열", bubbleSort(arr, SIZE));
		System.out.printf("총 이동 수: %d", count);
	}
}
