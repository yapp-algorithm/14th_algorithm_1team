public class BubbleSort {
	
	
	public void sort(int[] array) {
		int len = array.length;
		for(int i=0;i<len-1;i++) {
			for(int j=0; j<len-1-i; j++){
				if(array[j]>array[j+1]) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] numbers = {3,4,1,8,5,2,10};
		BubbleSort sorter = new BubbleSort();
		sorter.sort(numbers);
		for(int num:numbers) System.out.println(num);
	}
}
