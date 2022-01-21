import java.util.*;

public class Main15_11051 {
    static int N, K;
    static int[][] dp;
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();

        dp = new int[N+1][K+1];
        dp[2][1] = 2;

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                if (j == 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][1] + 1) % 10007;
                } else if (j == i-1) {
                    dp[i][j] = Math.max(dp[i][j], (dp[i-1][j-1] + 1)) % 10007;
                } else {
                    dp[i][j] = Math.max(dp[i][j], (dp[i-1][j-1] + dp[i-1][j])) % 10007;
                }
            }
        }
        
        System.out.println(dp[N][K]);

    }
}