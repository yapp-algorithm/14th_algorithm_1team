/*
 * 문제 : 프로그래머스 정렬 level2 - 가장 큰 수
 * 출처 : https://programmers.co.kr/learn/courses/30/parts/12198
 *
 * 작성일 : 2019.2.15
 * 작성자 : 고다경
 *
 * QuickSort
 */

package w1.solution;

public class Solution2_3 {
//    private static final int[] NUMBERS = new int[]{3, 30, 34, 5, 9};
//	private static final int[] NUMBERS = new int[]{12,121}; // 12121
	private static final int[] NUMBERS = new int[]{21, 212}; // 21221

    public static void main(String[] args) {
        System.out.println(solution(NUMBERS));
    }

    public static String solution(int[] numbers) {
        quickSort(numbers, 0, numbers.length-1);

        if(numbers[0] == 0) return "0";

        StringBuilder builder = new StringBuilder();
        for(int num : numbers)
            builder.append(num);

        return builder.toString();
    }

    public static void quickSort(int[] n, int start, int end) {
        if (start >= end) return;
        int middle = partition(n, start, end);
        quickSort(n, start, middle - 1);
        quickSort(n, middle + 1, end);
    }

    private static int partition(int[] n, int start, int end){
        int key = n[end];

        int i = start - 1;
        for(int j = start; j <= end-1; ++j)
//            if(n[j] < key) swap(n, ++i, j);
            if(compare(n[j], key)) swap(n, ++i, j);

        swap(n, i+1, end);
        return i+1;
    }

    private static boolean compare(int a, int b){
        StringBuilder builder = new StringBuilder();
        String ab = builder.append(a).append(b).toString();
        builder = new StringBuilder();
        String ba = builder.append(b).append(a).toString();

        if(ab.compareTo(ba) > 0) return true;
        return false;
    }

    private static void swap(int[] n, int i, int j){
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}