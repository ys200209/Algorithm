import java.io.*;
import java.util.*;

public class Main15_14501 {
    static int N, result=0;
    static int[] T, P, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[22];
        P = new int[22];
        dp = new int[22];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        

        for(int i=1; i<=N+1; i++) {
            if (dp[i] < result) dp[i] = result;
            dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            result = Math.max(result, dp[i]);
        }
        // result = Math.max(result, dp[N+1]); // 퇴사 당일의 금액과 비교

        /*System.out.println(Arrays.toString(T));
        System.out.println(Arrays.toString(P));
        System.out.println(Arrays.toString(dp));*/

        System.out.println(result);

    }
    
}