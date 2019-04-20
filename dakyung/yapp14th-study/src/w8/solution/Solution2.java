package w8.solution;

/**
 * 2017 서머코딩
 * 점프와 순간 이동 - level 2
 * https://programmers.co.kr/learn/challenges?selected_part_id=6174
 */
public class Solution2 {
//    private static int n = 5; // result 2
//    private static int n = 6; // result 2
    private static int n = 5000; // result 5

    public static void main(String[] args){
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int ans = 0;

        char[] nToCharArr = Integer.toBinaryString(n).toCharArray();
        for(char ch : nToCharArr)
            if(ch == '1') ans++;

        return ans;
    }
}
