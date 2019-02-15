/*
 * 문제 : 프로그래머스 정렬 level2 - 가장 큰 수
 * 출처 : https://programmers.co.kr/learn/courses/30/parts/12198
 *
 * 작성일 : 2019.2.15
 * 작성자 : 고다경
 *
 * Comparator
 */
package w1.solution;

import java.util.List;
import java.util.ArrayList;

public class Solution2_4 {
//    private static final int[] NUMBERS = new int[]{3, 30, 34, 5, 9};
//	private static final int[] NUMBERS = new int[]{12,121}; // 12121
    private static final int[] NUMBERS = new int[]{21, 212}; // 21221
//    private static final int[] NUMBERS = new int[]{0,0,0,0};

    public static void main(String[] args) {
        System.out.println(solution(NUMBERS));
    }

    public static String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int i : numbers) list.add(Integer.toString(i));

        list.sort((a, b) -> {
            return -Integer.compare(Integer.parseInt(a + b), Integer.parseInt(b + a));
        });

        if(list.get(0).charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : list)
            sb.append(s);
        return sb.toString();
    }
}
