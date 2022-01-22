import java.util.*;

public class Main15_11057 {
    static long result=0;
    static int N;
    static int[][] d;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        d = new int[1001][10];

        for(int i=0; i<10; i++) {
            d[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) {
                int sum = 0;
                for(int k=j; k<10; k++) {
                    sum += d[i-1][k];
                }
                d[i][j] = sum % 10007;
            }
        }

        for(int i=0; i<10; i++) {
            result += d[N][i];
        }

        System.out.println(result % 10007);

    }
}