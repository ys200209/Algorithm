import java.util.*;

public class Main16_30 {
    static int T, N, M, result=0;
    static int[][] gold, dp;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        T = scanner.nextInt();
        for(int t=0; t<T; t++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            gold = new int[N+1][M+1];
            dp = new int[N+1][M+1];
            
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    gold[i][j] = scanner.nextInt();
                }
            }

            dp[1][1] = gold[1][1];
            dp[2][1] = gold[2][1];
            dp[3][1] = gold[3][1];

            for (int x=2; x<=M; x++) {
                for(int y=1; y<=N; y++) {
                    if (y == 1) dp[y][x] = Math.max(dp[y][x], Math.max(dp[y][x-1], dp[y+1][x-1]) + gold[y][x]);
                    else if (y == N) dp[y][x] = Math.max(dp[y][x], Math.max(dp[y][x-1], dp[y-1][x-1]) + gold[y][x]);
                    else {
                        dp[y][x] = Math.max(dp[y][x], Math.max(dp[y][x-1], Math.max(dp[y+1][x-1], dp[y-1][x-1])) + gold[y][x]);
                    }
                }
            }

            result = 0;
            for(int i=1; i<=N; i++) {
                result = Math.max(result, dp[i][M]);
            }

            sb.append(result + "\n");
        }

        System.out.println(sb);

    }
    
}
