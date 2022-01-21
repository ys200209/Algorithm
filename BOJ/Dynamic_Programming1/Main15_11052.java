import java.io.*;
import java.util.*;

public class Main15_11052 {
    static int N, result=0;
    static int[] pay, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pay = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int i=1;
        while(st.hasMoreTokens()) {
            pay[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        dp[0] = 0;
        dp[1] = pay[1];
        result = dp[1];

        for(i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], Math.max(pay[i], (dp[j] * (i/j)) + dp[i % (j * (i/j))] ));
            }

            result = Math.max(result, dp[i]);
        }

        // System.out.println(Arrays.toString(dp));

        System.out.println(result);


    }
    
}