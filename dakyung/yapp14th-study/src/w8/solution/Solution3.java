package w8.solution;

/**
 * 2017 서머코딩
 * 기지국 설치 - level 3
 * https://programmers.co.kr/learn/challenges?selected_part_id=6174
 *
 * 실패
 */
public class Solution3 {
    // n : 아파트의 개수
    // stations : 기지국이 설치된 곳
    // w : 도달 범위
    private static int n = 11;
    private static int[] stations = {4, 11};
    private static int w = 1; // result = 3

//    private static int n = 16;
//    private static int[] stations = {9};
//    private static int w = 2; // result = 3

    public static void main(String[] args){
        System.out.println(solution(n, stations, w));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w*2 +1;
        boolean[] checkArr = new boolean[n]; // init false

        checkArr = check(stations, w, checkArr);

        int start = 0;
        int end = 0;
        for(int i=0; i<n; i++){
            if(i == n-1) {
                end = i;
                int result = (end-start+1);
                answer += result/range;
                if(result%range!=0) answer += 1;
            }
            if(checkArr[i]==true){
                int result = (end-start+1);
                answer += result/range;
                if(result%range!=0) answer += 1;

                if(i + range >= n-1) break;
                i += range;
                start = i;
            }
            if(checkArr[i]==false){
                end = i;
            }
        }

        return answer;
    }

    private static boolean[] check(int[] stations, int w, boolean[] check){
        for(int station : stations){
            station -= 1;
            check[station] = true;
            for(int i=1; i<=w; i++){
                if(station-i >= 0) check[station-i] = true;
                if(station+i < check.length) check[station+i] = true;
            }
        }
        return check;
    }
}
