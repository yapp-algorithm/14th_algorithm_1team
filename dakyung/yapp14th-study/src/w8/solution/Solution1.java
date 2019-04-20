package w8.solution;

import java.util.Arrays;

/**
 * 2017 서머코딩
 * 소수 만들기 - level 2
 * https://programmers.co.kr/learn/challenges?selected_part_id=6174
 */
public class Solution1 {
    private static int[] nums = {1,2,3,4}; // result = 1
//    private static int[] nums = {1,2,7,6,4}; // result = 4
    private static int count = 0;

    public static void main(String[] args){
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int n = nums.length;
        int r = 3;
        int[] combArr = new int[r];

        doCombination(combArr, n, r, 0, 0, nums);

        return count;
    }

    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr){
        System.out.println("=> "+n+" "+r+" "+index+" "+target);

        // 원소를 다 뽑은 경우
        if(r == 0){
            System.out.println(Arrays.toString(combArr));
            int sum = 0;
            for(int i=0; i<index; i++) {
                System.out.print(arr[combArr[i]] + " ");
                sum += arr[combArr[i]];
            }
            if(isPrime(sum)) count++;

            System.out.println();

            // 끝까지 검사한 경우
        }else if(target == n){
            return;
        }else{
            combArr[index] = target;
            // (i) 뽑는 경우
            doCombination(combArr, n, r-1, index+1, target+1, arr);

            //(ii) 안 뽑는경우
            doCombination(combArr, n, r, index, target+1, arr);
        }
    }

    private static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
