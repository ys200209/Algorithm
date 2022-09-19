package BOJ.Brute_Force;

import java.io.*;
import java.util.*;

public class Main11_17626 {
    static int N;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N+1];

        for(int i=1; i<=N; i++) {
            int pow = (int) Math.pow(i, 2);

            if (pow <= N) dp[pow] = 1;

            for(int j=pow*2; j<=N; j+=pow) {
                if (dp[j] == null) dp[j] = dp[j-pow] + 1;
                else dp[j] = Math.min(dp[j], dp[j-pow] + 1);
            }

        }

        System.out.println(Arrays.toString(dp));

    }

}