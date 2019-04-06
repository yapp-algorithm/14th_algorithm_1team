package w7.practice;

public class FibonacciRecursive {
    static int count = 0;

    static int fibonacci(int n) {
        System.out.printf("fibonacci(%d)\n", n);
        count++;
        if(n == 1|| n==2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args){
        int value = fibonacci(7);
        System.out.printf("value : %d\n", value);
        System.out.printf("count : %d", count);
    }
}
