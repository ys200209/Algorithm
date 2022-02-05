import java.util.*;

public class Main15_2293 {
    static int N, K;
    static int[] coin, dp;
    // static int[][] ;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();
        coin = new int[N+1]; // 101
        dp = new int[K+1]; // 10001

        for(int i=1; i<=N; i++) {
            coin[i] = scanner.nextInt();
        }

        for(int i=1; i<=N; i++) {
            for(int j=coin[i]; j<=K; j++) {
                dp[j] = dp[j - coin[i]] + 1;
            }
        }

        System.out.println(Arrays.toString(dp));

        
    }
    
}
