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

        /*dp[1] = 1;
        for(int i=2; i*i<=N; i++) {
            dp[i*i] = 1;

            for(int j=(i-1)*(i-1)+1; j<i*i; j++) {
//                if (dp[])
                int num = (i-1)*(i-1);
                dp[j] = dp[num] + dp[j-num];
            }
        }*/

        recursive(N);

//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[N]);

        System.out.println(Math.sqrt(N));
        System.out.println((int)Math.sqrt(N));
//        System.out.println(Math.sqrt(N) % 1);


    }

    private static int recursive(int n) {
        int sqrt = (int) Math.sqrt(n);

        if (Math.sqrt(n) % 1 == 0) return dp[n] = 1;
        else return dp[n] = Math.min(recursive(sqrt*sqrt) + recursive(n-(sqrt*sqrt)), recursive(sqrt*sqrt)+1);
    }

}