import java.util.*;
import java.io.*;

public class Main35_2458 {
    static int INF = (int)1e9;
    static int N, M, result=0;
    static int[][] dp;
    static int[] A;
    static Queue<Integer> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N+1][N+1];
        
        for(int i=0; i<=N; i++) {
            Arrays.fill(dp[i], INF);

            for(int j=0; j<=N; j++) {
                if (i == j) dp[i][j] = 0;
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dp[A][B] = 1;
        }

        for(int k=1; k<=N; k++) { // 플로이드 워셜 알고리즘
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            boolean check = true;
            for(int j=1; j<=N; j++) {
                if (dp[i][j] == INF && dp[j][i] == INF) {
                    check = false;
                    break;
                }
            }
            if (check) result++;
        }

        System.out.println(result);


    }

}