package w7.practice;

public class FibonacciDynamic {
    static int[] a = new int[100];
    static int count = 0;

    static int fibonacci(int n) {
        System.out.printf("fibonacci(%d)\n", n);
        count++;
        if(a[n] != 0) return a[n];
        if(n == 1 || n == 2) a[n] = 1;
        else a[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return a[n];
    }

    public static void main(String[] args){
        int value = fibonacci(7);
        System.out.printf("value : %d\n", value);
        System.out.printf("count : %d", count);
    }
}
