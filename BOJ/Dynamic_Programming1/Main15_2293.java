import java.io.*;
import java.util.*;

public class Main15_2293 {
    static int N, K;
    static int[] coin, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        dp = new int[K+1];

        for(int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // dp[0] = 1;

        for(int i=0; i<N; i++) {
            dp[coin[i]] += 1;
            for(int j=coin[i]; j<=K; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        
    }
    
}