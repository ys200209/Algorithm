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
            if (coin[i] == K) dp[1] = 1;
        }

        for(int i=2; i<=K; i++) { // 1~K원 까지의 경우의 수를 DP 배열에 등록
            
            
            for(int j=1; j<=N; j++) {
                if (dp[i] == 0) {
                    // dp[i] += K
                    
                }
            }


        }

        System.out.println(Arrays.toString(dp));

        
    }
    
}
