package w7.practice;

public class MatrixPathRecursive {
    static int[][] a = { { 6, 7, 12, 5},
                        {5, 3, 11, 18},
                        {7, 17, 3, 3},
                        {8, 10, 14, 9}};
    static int count = 0;

    static int score(int r, int c){
        System.out.printf("score(%d, %d)\n", r, c);
        count++;

        int beforeScore = 0;
        if(r == 0 && c == 0) beforeScore = 0;
        else if(r == 0) beforeScore = score(r, c - 1);
        else if(c == 0) beforeScore = score(r - 1, c);
        else beforeScore = Math.min(score(r, c-1), score(r-1, c));

        System.out.printf("beforeScore : %d, value : %d\n", beforeScore, a[r][c]);
        return beforeScore + a[r][c];
    }

    public static void main(String[] args){
        System.out.println(score(3,3));
        System.out.printf("count : %d", count);
    }
}
