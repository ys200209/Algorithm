import java.util.*;
import java.io.*;

public class Main15_9084 {
    static int T, N, M;
    static int[] coin, dp;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            coin = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            int i=0;
            while(st.hasMoreTokens()) {
                coin[i] = Integer.parseInt(st.nextToken());
                i++;
            }

            M = Integer.parseInt(br.readLine());
            dp = new int[M+1];

            for(i=0; i<N; i++) {
                if (coin[i] > M) break;
                dp[coin[i]] += 1;

                for(int j=coin[i]; j<=M; j++) {
                    dp[j] = dp[j] + dp[j - coin[i]];
                }
            }
            sb.append(dp[M] + "\n");
        }
        System.out.println(sb);
    }
}