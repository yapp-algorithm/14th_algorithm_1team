package seventh_week;

import java.util.ArrayList;
import java.util.Stack;

public class MakePrimeNumber {
    static int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        Combination combination = new Combination(nums);
        ArrayList<Integer> sum = combination.doCombination(n, 3, 0);
        for (int i = 0; i < sum.size(); i++){
            if (IsPrimeNumber(sum.get(i))){
                answer++;
            }
        }
        return answer;
    }
    static boolean IsPrimeNumber(int n) //함수 정의문
    {
        int i = 0;
        int last = n / 2;   //약수가 없는 수가 소수이므로 2부터 n/2(자기자신/2)까지만 확인하면 됨
        if (n <= 1)//소수는 1보다 큰 자연수여야 함
        {
            return false;
        }
        //(자기자신/2)보다 큰수는 약수가 될 수 없음
        for (i = 2; i <= last; i++) //i를 2부터 last까지 1씩 증가시키며 반복 수행
        {
            if ((n%i) == 0) //n을 i로 나누었을때 나머지가 0이면(즉, i는 n의 약수가 아님)
            {
                return false; //소수가 아니므로 0반환(i가 약수이므로 n은 소수가 아님)
            }
        }
        return true; //1~last(자기자신/2)사이에 약수가 없으므로 소수임
    }
    static class Combination{
        private int[] arr;     //기준 배열
        private Stack<Integer> st; //조합을 저장할 스택
        ArrayList<Integer> arrayList = new ArrayList<>();
        public Combination(int[] arr){
            this.arr = arr;             //배열을 받아 객체에 저장한다.
            st = new Stack<>(); //스택에 메모리를 할당한다.
        }
        public void showStack(){
            //스택에 있는 값들을 출력한다.
            int result = 0;
            for(int i=0;i<st.size();i++){
                System.out.print(st.get(i)+" ");
                result += st.get(i);
            }
            System.out.println("-> " + result);
            arrayList.add(result);
        }

        public ArrayList<Integer> doCombination(int n, int r, int index){
            // n : 전체 개수
            // r : 뽑을 개수
            // index 배열이다보니 현재 배열의 어디를 가리키고 있는지 필요하므로.
            if(r==0){
                //0개를 뽑는다는건 더 이상 뽑을 것이 없다는 말과 같으므로  스택을 출력하고 함수를 종료한다.
                showStack();
            }
            else if(n==r){
                //nCr 이라는 건 나머지를 전부 뽑겠다는 말과 같으므로 전부 스택에 넣은 후 출력하면 된다.
                for(int i=0;i<n;i++)st.add(arr[index+i]);//index부터 n개를 차례대로 스택에 넣고
                showStack(); //스택을 보여준다.
                for(int i=0;i<n;i++)st.pop(); //이후 전부 pop을 시켜 다음 과정을 진행한다.
            }
            else{
                //저 두가지 예외 사항을 빼면 점화식대로 진행하면 된다.

                //index를 포함하는 경우
                st.add(arr[index]);
                doCombination(n-1,r-1,index+1); //index를 스택에 넣은상태로 index를 1옮겨 그대로 진행.

                //index를 포함하지 않는 경우
                st.pop(); //index를 제거해주고
                doCombination(n-1, r, index+1); //index를 제외한 상태에서 n-1Cr 진행.
            }
            return arrayList;
        }
    }
    public static void main(String[] ars){
        int[] a = {1, 2, 3, 4};
        System.out.println("answer is " + solution(a));
        int[] b = {1, 2, 7, 6, 4};
        System.out.println("answer is " + solution(b));
    }
}
