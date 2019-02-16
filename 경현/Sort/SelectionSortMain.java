
public class SelectionSortMain {
	public static void selectSort(int[] array) {
		int minIndex = 0;//최솟값의 인덱스를 저장
		
		//전체 탐색
		for(int i=0;i<array.length-1;i++) {
			minIndex = i;
			//최소값 탐색
			for(int j=i;j<array.length;j++) {				
				if(array[j]<array[minIndex]) {
					minIndex = j;
				}
			}
			
			//최소값을 맨 앞으로 보내기
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;	
			//전체 탐색 for문에서 i++이 되기 때문에 자연스럽게 이전 최소값을 빼고 다음 최소값을 찾는다.
		}
	}

	public static void main(String[] args) {
		int[] numbers = {3,9,2,19,20,1,32};
		selectSort(numbers);
		for(int num:numbers) System.out.println(num);
	}

}