package seventh_week;

public class JumpAndTeleport {
    static int solution(int n) {
        int ans = 0;
        Calculate c = new Calculate();
        ans = c.calculate(n);
        return ans;
    }
    static class Calculate{
        int temp = 0;
        int battery = 0;
        public int calculate(int n) {
            if (temp == n){
                return battery;
            }
            else {
                System.out.println("temp: " + temp);
                if (temp == 0) {
                    temp = jump(temp);
                    battery++;
                    System.out.println("result: " + temp);
                } else if (temp == 1) {
                    temp = teleport(temp);
                    System.out.println("result: " + temp);
                } else if (temp > 1 && temp <= n / 2) {
//                    if ((temp + 1)*2 > n){
                        temp = teleport(temp);
                        System.out.println("result: " + temp);
//                    }
//                    else{
//                        temp = jump(temp);
//                        battery++;
//                        temp = teleport(temp);
//                        System.out.println("result: " + temp);
//                    }
                } else {
                    temp = jump(temp);
                    battery++;
                    System.out.println("result: " + temp);
                }
                return calculate(n);
            }
        }
        private int jump(int temp){
            return temp + 1;
        }
        private int teleport(int temp){
            return temp * 2;
        }
    }
    public static void main(String[] ars){
//        System.out.println("answer is " + solution(5));
//        System.out.println("answer is " + solution(6));
        System.out.println("answer is " + solution(5000));
    }
}