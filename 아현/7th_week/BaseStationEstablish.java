package seventh_week;

import java.util.ArrayList;

public class BaseStationEstablish {
    static int solution(int n, int[] stations, int w) {
        int answer, i, t;

        ArrayList list = new ArrayList();
        for (i = 0; i < n; i++){
            list.add(false);
        }

        for (i = 0; i < stations.length; i++) {
            t = stations[0] - 1;
            list.set(t, true);
//            if (t - w >= 0)
            //w만큼 앞뒤로 true
        }

        for (i = 0; i < n; i++){
            //false 덩어리끼리 쪼개기
        }
        //덩어리 개수 % (2 * w + 1) == 0 이면 개수/(2 * w + 1) 아니면 개수/(2 * w + 1) + 1
        answer = 0;
        return answer;
    }
    public static void main(String[] ars){
        int[] a = {4, 11};
        System.out.println("answer is " + solution(11, a, 1));
        int[] b = {9};
        System.out.println("answer is " + solution(16, b, 2));
    }
}

