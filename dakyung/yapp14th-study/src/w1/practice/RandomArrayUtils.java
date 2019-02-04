package w1.practice;

import java.util.Random;

public class RandomArrayUtils {
	
	private static final Random random = new Random();
	
	public static Integer[] integerArrayCreate(int size){
		Integer[] arr = new Integer[size];
		for(int i=0; i<size; i++)
			arr[i] = random.nextInt(100);
		return arr;
	}
	
	public static <T> void arrayPrint(String str, T[] arr){
		System.out.printf("> %s\n", str);
		for(T t : arr)
			System.out.printf("%s ",t);
		System.out.println();
	}
}
