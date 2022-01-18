import java.io.*;
import java.util.*;

public class Main15_11048 {
    static int N, M;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[1001][1001];
        dp = new int[1001][1001];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j=1;
            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        dp[1][1] = map[1][1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if (i-1 >= 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + map[i][j]);
                } 
                if (j-1 >= 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + map[i][j]);
                }
            }
        }

        /*for(int i=0; i<=N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/

        System.out.println(dp[N][M]);

    }
    
}
